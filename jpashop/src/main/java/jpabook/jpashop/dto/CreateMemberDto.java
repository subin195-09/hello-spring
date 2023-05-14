package jpabook.jpashop.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class CreateMemberDto {
    @NotEmpty(message = "회원 이름은 피루 십니다.")
    private String name;
    private String city;
    private String street;
    private String zipcode;
}
