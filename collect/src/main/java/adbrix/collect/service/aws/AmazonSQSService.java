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

    private final ObjectMapper objectMapper;
    private final AmazonSQS amazonSQS;

    @Value("${cloud.aws.sqs.queue.url}")
    private String SQSUrl;

    public void send(Object event) throws JsonProcessingException {
        SendMessageRequest messageRequest = new SendMessageRequest(SQSUrl, objectMapper.writeValueAsString(event));
        amazonSQS.sendMessage(messageRequest);
    }
}
