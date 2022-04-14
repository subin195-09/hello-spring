package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // JPQL : select m from Member m where m.name = ?
    // 기본 제공 method 외에는 이름의 틀에 맞게 작성하면 된다.
    @Override
    Optional<Member> findByName(String name);
}
