package jpabook.jpashop.controller;

import jpabook.jpashop.dto.CreateOrderDto;
import jpabook.jpashop.dto.OrderSearchDto;
import jpabook.jpashop.entity.Order;
import jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order/new")
    public Long createOrder(@RequestBody CreateOrderDto createOrderDto) {
        Long orderId = orderService.order(
                createOrderDto.getMemberId(),
                createOrderDto.getItemId(),
                createOrderDto.getCount()
        );

        return orderId;
    }

//    @GetMapping("/orders")
//    public List<Order> getOrders(@RequestBody OrderSearchDto orderSearchDto) {
//        return orderService.findOrders(orderSearchDto);
//    }

    @DeleteMapping("/order/cancel/{id}")
    public void cancelOrder(@PathVariable("id") Long orderId) {
        orderService.cancelOrder(orderId);
    }
}
