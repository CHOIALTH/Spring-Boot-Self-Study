package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

/*    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/
/*    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }*/
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /* 스프링 빈을 등록하겠다*/
    @Bean
    /* 스프링이 뜰 때 @Configuration 읽고, memberService() 로직을 호출해서
    * MemberService를 스프링 빈에 등록 됨*/
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
    
    // AOP 사용 시 @Component 처리보다는 아래와 같이, AOP 사용 중임을 명시하는 것이 권장됨
/*    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }*/

}
