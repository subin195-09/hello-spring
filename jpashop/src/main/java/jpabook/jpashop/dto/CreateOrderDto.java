package jpabook.jpashop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateOrderDto {
    private Long memberId;
    private Long itemId;
    private int count;

}
