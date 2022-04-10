package adbrix.collect.api;

import adbrix.collect.api.dto.EventResult;
import adbrix.collect.service.EventCollectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class EventCollectController {

    private final EventCollectService eventCollectService;

    @PostMapping("/api/collect")
    public EventResult collect(@RequestBody Object event){
        return eventCollectService.collectEvent(event);
    }
}
