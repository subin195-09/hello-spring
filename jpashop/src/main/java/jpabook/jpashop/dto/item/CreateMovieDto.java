package jpabook.jpashop.dto.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMovieDto extends CreateItemDto {
    private String director;
    private String actor;
}
