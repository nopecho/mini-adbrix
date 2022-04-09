package adbrix.clientbot.web.controller;

import adbrix.clientbot.service.EventService;
import adbrix.clientbot.web.util.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class EventContoller {

    private final EventService eventService;

    @GetMapping("/home")
    public void homeEventHandler(){
        eventService.execute(EventType.HOME);
    }

    @GetMapping("/login")
    public void loginEventHandler(){
        eventService.execute(EventType.LOGIN);
    }

    @GetMapping("/post")
    public void postLookupEventHandler(){
        eventService.execute(EventType.GET_POST);
    }

    @GetMapping("/posts")
    public void postListLookupEventHandler(){
        eventService.execute(EventType.GET_POST_LIST);
    }

    @GetMapping("/random")
    public void randomEventHandler(){
        eventService.execute(EventType.RANDOM);
    }
}

