package adbrix.collect.service.aws;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AmazonSQSService {

    private final ObjectMapper objectMapper; //Object to Json 변환 객체
    private final AmazonSQS amazonSQS; //Amazon SQS Client 객체 ( config 빈등록 객체 )

    @Value("${cloud.aws.sqs.queue.url}")
    private String SQSUrl; //aws sqs url 정보

    /**
     * SQS message 전송 메서드
     * @param event : 전송할 메시지 event 객체
     * @throws JsonProcessingException : Object to Json 파싱 예외
     */
    public void send(Object event) throws JsonProcessingException {
        SendMessageRequest messageRequest = new SendMessageRequest(SQSUrl, objectMapper.writeValueAsString(event));
        amazonSQS.sendMessage(messageRequest);
    }
}
