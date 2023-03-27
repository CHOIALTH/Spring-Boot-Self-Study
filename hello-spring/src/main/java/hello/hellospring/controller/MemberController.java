package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/* @Controller가 있으면 스프링 컨테이너에 멤버컨트롤러 생성해서 넣어둠 */
@Controller
public class MemberController {
    /* 이하 생성자 주입을 통한 DI */
    /* 생성자 호출함 -> @Autowired 사용하면, 스프링 컨테이너 내 멤버서비스를 가져다 연결시켜줌*/
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
        System.out.println("memberService = " + memberService.getClass());
    }

    /* 회원 등록 */
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        System.out.println("member = " + member);
        System.out.println("member = " + member.getName());
        memberService.join(member);

        /* 홈화면으로 돌려 보냄*/
        return "redirect:/";
    }

    /* 회원 조회 */
    @GetMapping("/members")
    public String memberList(Model model){
        List<Member> members = memberService.findMembers();
        /* "members"라는 key에 List타입의 members 담아둠(모든회원 조회한 것) */
        model.addAttribute("members", members);

        return "members/memberList";
    }

    /* 이하 Setter 주입을 통한 DI*/
    /* private MemberService memberService;

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/

    /* 이하 필드 주입을 통한 DI*/
    /*@Autowired private MemberService memberService;*/

}
