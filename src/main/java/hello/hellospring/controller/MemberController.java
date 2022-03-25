package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";

    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
