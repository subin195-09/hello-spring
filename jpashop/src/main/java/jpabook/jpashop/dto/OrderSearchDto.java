package jpabook.jpashop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearchDto {
    private String memberName;
    private OrderStatus orderStatus;
}
