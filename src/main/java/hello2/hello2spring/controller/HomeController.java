package hello2.hello2spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //8080으로 들어오면 아래 함수 호출됨
    @GetMapping("/")
    public String home(){
        return "home";
    } // => templates/ home.html 호출됨
}
