package hello2.hello2spring.controller;

import hello2.hello2spring.service.MemberService;
import hello2.hello2spring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.lang.reflect.Constructor;
import java.util.List;


@Controller
public class MemberController {


    //@Autowired
    private  MemberService memberService ;

//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

   @Autowired //의존주입 (의존관계)
   public MemberController(MemberService memberService) {
       this.memberService = memberService;
   }

   @GetMapping("/members/new")
    public String createForm(){
       return "members/createMemberForm"; // Templates 에서 members - createMemberForm.html 로간다
   }
   @PostMapping("/members/new")
   public String create(MemberForm form){
       Member member  = new Member();
       member.setName(form.getName());

       System.out.println("member = " + member.getName());
       memberService.join(member);
       return "redirect:/";
   }

   @GetMapping("members")
    public String list(Model model){
       List<Member> members = memberService.findMembers();
       model.addAttribute("members",members);
       return "members/memberList";
   }
}
