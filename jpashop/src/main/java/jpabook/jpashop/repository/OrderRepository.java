package jpabook.jpashop.repository;

import jpabook.jpashop.dto.OrderSearchDto;
import jpabook.jpashop.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> searchOrder(OrderSearchDto orderSearchDto) {
        String jpql = "select o from Order join o.member m";
        boolean isFirstCondition = true;

        if (orderSearchDto.getOrderStatus() != null) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += "and";
            }
            jpql += " o.status = :=status";
        }

        if (StringUtils.hasText(orderSearchDto.getMemberName())) {
            if (isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " m.name like :name";
        }

        TypedQuery<Order> query = em.createQuery(jpql, Order.class)
                .setMaxResults(1000);

        if (orderSearchDto.getOrderStatus() != null) {
            query = query.setParameter("status", orderSearchDto.getOrderStatus());
        }
        if (StringUtils.hasText(orderSearchDto.getMemberName())) {
            query = query.setParameter("name", orderSearchDto.getMemberName());
        }

        return query.getResultList();
    }
}
