package jpabook.jpashop.dto.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookDto extends CreateItemDto{
    private String author;
    private String isbn;
}
