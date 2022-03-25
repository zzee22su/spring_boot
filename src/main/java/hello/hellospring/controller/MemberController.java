package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    //스프링 실행될 때, 스프링 컨테이너가 생긴다.
    //거기에 @Controller가 있으면 MemoberController 객체를 생성을 해서  spring 에 넣어둔다.
    //그리고 spring이 관리한다.

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    //MemberService를 spring이 spring 컨테이너에 있는 memberservice를 가져다가 연결을 해준다.

//    MemberController가 등록될 때 Spring Bean에 등록되어 있는 MemberService 객체를 넣어준다. => Dependency Injection
}
