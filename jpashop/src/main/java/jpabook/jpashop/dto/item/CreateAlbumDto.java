package jpabook.jpashop.dto.item;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAlbumDto extends CreateItemDto{
    private String artist;
    private String etc;
}
