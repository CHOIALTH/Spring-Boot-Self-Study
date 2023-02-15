package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    //MemberService 입장에서는 직접 new 하지 않고 memberRepository를 외부에서 넣어줌.
    //이런 것을 DI(Dependency Injection)라고 함
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 회원 가입
    public Long join(Member member){
    // 같은 이름을 가진 회원은 안된다는 조건
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        // join 실행되면 1. 중복검사 2. 저장
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                        .ifPresent(m ->{
                            // 이름이 중복될 경우 아래의 예외를 던짐
                            throw new IllegalStateException("이미 존재하는 이름입니다. 중복!");
                        });
    }
    // 전체 회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


}
