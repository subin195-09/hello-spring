package jpabook.jpashop.service;

import jpabook.jpashop.entity.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;


@RunWith(SpringRunner.class) // 스프링과 테스트 통합
@SpringBootTest // 스프링 부트 띄우고 테스트
@Transactional // 각 테스트 별로 트랜잭션이 시작되고, 테스트가 끝나면 롤백됨
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    @Test
    public void join() throws Exception {
        //given
        Member member = new Member();
        member.setName("skim");

        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findById(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void duplicated_user() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("sbkim");

        Member member2 = new Member();
        member2.setName("sbkim");

        //when
        memberService.join(member1);
        memberService.join(member2);

        //then
        fail("예외 발생!!");
    }
}
