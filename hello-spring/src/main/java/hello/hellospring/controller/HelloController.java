package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam(name = "name") String name, Model model){
        model.addAttribute("name" ,name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    /*html에 나오는 Body 태그 말하는 것 X*/
    /*http 통신 프롴토콜의 head부, body부 중 body부에 직접 넣어주겠다  */
    @ResponseBody
    public String helloString(@RequestParam(name="name") String name){
        return "hello" + name;
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        // 여기서 hello는 객체
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }

}
