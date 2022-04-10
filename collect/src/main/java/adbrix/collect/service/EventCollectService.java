package adbrix.collect.service;

import adbrix.collect.api.dto.EventResult;
import adbrix.collect.service.aws.AmazonSQSService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventCollectService {

    private final AmazonSQSService amazonSQSService; //Amazon SQS 처리 객체

    /**
     * Event -> SQS Event 수집 메서드
     * @param event : 수집할 event 객체
     */
    public EventResult collectEvent(Object event) throws JsonProcessingException {
        amazonSQSService.send(event);
        return new EventResult(true);
    }
}
