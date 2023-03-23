package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    /* 스프링 빈을 등록하겠다*/
    @Bean
    /* 스프링이 뜰 때 @Configuration 읽고, memberService() 로직을 호출해서
    * MemberService를 스프링 빈에 등록 됨*/
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        /* MemberRepository는 인터페이스고, MemoryMemberRepository가 구현체이므로*/
        return new MemoryMemberRepository();
    }

}
