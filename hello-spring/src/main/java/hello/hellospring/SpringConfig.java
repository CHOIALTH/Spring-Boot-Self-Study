package hello.hellospring;

import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /* 스프링 빈을 등록하겠다*/
    @Bean
    /* 스프링이 뜰 때 @Configuration 읽고, memberService() 로직을 호출해서
    * MemberService를 스프링 빈에 등록 됨*/
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
/*    @Bean
    public MemberRepository memberRepository(){
        *//* MemberRepository는 인터페이스고, MemoryMemberRepository가 구현체이므로*//*
        return new MemoryMemberRepository();
    }*/
    @Bean
    public MemberRepository memberRepository(){
        // return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }

}
