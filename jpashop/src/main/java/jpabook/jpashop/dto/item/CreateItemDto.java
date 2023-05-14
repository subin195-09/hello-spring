package jpabook.jpashop.dto.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class CreateItemDto {
    private String name;
    private int price;
    private int stockQuantity;
    private String dtype;
}
