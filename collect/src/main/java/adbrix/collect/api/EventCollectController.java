package adbrix.collect.api;

import adbrix.collect.api.dto.EventResult;
import adbrix.collect.service.EventCollectService;
import com.fasterxml.jackson.core.JsonProcessingException;
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

    /**
     * Event Collect Handler
     * @param event : client-bot 에서 발생한 이벤트 객체 (json 타입)
     * @return : event 수집 결과
     * @throws JsonProcessingException : Object to Json 파싱 예외
     */
    @PostMapping("/api/collect")
    public EventResult collect(@RequestBody Object event) throws JsonProcessingException {
        return eventCollectService.collectEvent(event);
    }
}
