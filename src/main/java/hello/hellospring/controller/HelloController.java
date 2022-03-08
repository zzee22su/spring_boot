package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // src/main/resources/templates 경로의 hello.html을 찾는다. -> Thymeleaf 템플릿 엔진이 처리 해줌.
    }

}
