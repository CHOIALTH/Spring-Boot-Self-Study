package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.apache.tomcat.util.http.fileupload.MultipartStream;


public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    // 회원가입
    public Long join(Member member){
    // 같은 이름을 가진 회원은 안된다는 조건

        memberRepository.save(member);
        return member.getId();
    }
}
