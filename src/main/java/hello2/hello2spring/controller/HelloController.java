package hello2.hello2spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello") // -> web어플리케이션에서 '/hello' 라고 들어오면 이 메소드를 호출하게끔 함
    public String hello(Model model){
        model.addAttribute("data","hello!!"); //키 , 밸류
        return "hello";//resources/templates/hello.html 실행시켜라
    }
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name" ) String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http 응답 바디부분에 리턴값을 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; // html 템플릿엔진 거치지않고 받은 문자 그대로 출력됨
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // json 객체로 반환 키: 밸류  리턴이 객체로 오면  json으로 반환하는게 디폴트
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
