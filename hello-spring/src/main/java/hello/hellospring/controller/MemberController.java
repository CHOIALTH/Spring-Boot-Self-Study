package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/* @Controller가 있으면 스프링 컨테이너에 멤버컨트롤러 생성해서 넣어둠 */
@Controller
public class MemberController {
    private final MemberService memberService;
    /* 생성자 호출함 -> @Autowired 사용하면, 스프링 컨테이너 내 멤버서비스를 가져다 연결시켜줌*/
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
