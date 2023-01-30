package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    // 웹브라우저에서 /hello를 던짐 -> 부트 내장 톰캣 -> GetMapping("hello")
    // Map Application에서 /hello로 들어오면 아래의 메서드를 호출함
    @GetMapping("hello")
    // Spring이 model이란 것을 만들어 넣어줌.
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        // IntelliJ Ultimate Ver에서는 Ctrl + 클릭 하면 해당 경로로 이동시켜준다
        return "hello";
    }
}
