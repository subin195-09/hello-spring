package jpabook.jpashop.controller;

import jpabook.jpashop.dto.CreateMemberDto;
import jpabook.jpashop.entity.Address;
import jpabook.jpashop.entity.Member;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/new")
    public Long join(@RequestBody CreateMemberDto createMemberDto) {
        Address address = new Address(
                createMemberDto.getCity(),
                createMemberDto.getStreet(),
                createMemberDto.getZipcode());

        Member member = new Member();
        member.setName(createMemberDto.getName());
        member.setAddress(address);

        Long memberId = memberService.join(member);
        return memberId;
    }

    @GetMapping("/members")
    public List<Member> getMembers() {
        List<Member> members = memberService.findMembers();
        return members;
    }

    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable("id") Long memberId) {
        Member member = memberService.findOne(memberId);
        return member;
    }
}
