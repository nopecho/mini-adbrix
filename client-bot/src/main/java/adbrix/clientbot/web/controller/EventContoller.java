package adbrix.clientbot.web.controller;

import adbrix.clientbot.service.EventService;
import adbrix.clientbot.web.dto.event.EventResult;
import adbrix.clientbot.web.util.EventType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EventContoller {

    private final EventService eventService;

    @GetMapping("/home")
    public EventResult homeEventHandler(){
        return eventService.execute(EventType.HOME);
    }

    @GetMapping("/login")
    public EventResult loginEventHandler(){
        return eventService.execute(EventType.LOGIN);
    }

    @GetMapping("/post")
    public EventResult postLookupEventHandler(){
        return eventService.execute(EventType.GET_POST);
    }

    @GetMapping("/posts")
    public EventResult postListLookupEventHandler(){
        return eventService.execute(EventType.GET_POST_LIST);
    }

    @GetMapping("/random")
    public EventResult randomEventHandler(){
        return eventService.execute(EventType.radomEvent());
    }
}

