package adbrix.clientbot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventContoller {

    @GetMapping("/home")
    public void homeEvent(){

    }

    @GetMapping("/login")
    public void loginEvent(){

    }

    @GetMapping("/post")
    public void postSearchEvent(){

    }

    @GetMapping("/posts")
    public void postListSearchEvent(){

    }

    @GetMapping("/random")
    public void randomEvent(){

    }
}

