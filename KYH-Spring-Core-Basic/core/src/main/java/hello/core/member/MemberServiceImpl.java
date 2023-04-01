package hello.core.member;

// 관례상 구현체 1개뿐일때는 구현체명 뒤에 Impl이라고 많이 씀
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    // join에서 save 호출하면, 다형성에서 MemoryMemberRepository에 있는 save가 호출됨(오버라이드한 것)
    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
