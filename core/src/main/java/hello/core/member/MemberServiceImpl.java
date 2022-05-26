package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // null point exception 때문에 구현 객체를 선택해주어야 한다.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
