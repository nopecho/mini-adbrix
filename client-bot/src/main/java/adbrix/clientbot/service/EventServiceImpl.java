package adbrix.clientbot.service;

import adbrix.clientbot.web.dto.event.Event;
import adbrix.clientbot.web.dto.event.EventResult;
import adbrix.clientbot.web.dto.event.prams.*;
import adbrix.clientbot.web.dto.post.Category;
import adbrix.clientbot.web.dto.post.Post;
import adbrix.clientbot.web.dto.user.User;
import adbrix.clientbot.web.util.EventType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    private final RestTemplate restTemplate;
    private final Random random = new Random();
    private final String COLLECT_SERVER_URL = "http://localhost:8082/api/collect";

    @Override
    public EventResult execute(EventType eventType) {
        Event event = createEvent(eventType);
        log.info("event 발생 ! = {}",event.getEvent());
        return restTemplate.postForObject(COLLECT_SERVER_URL, event, EventResult.class);
    }

    private Event createEvent(EventType eventType){
        User user = createUser();
        return Event.builder()
                .eventId(eventType.getCode())
                .userId(user.getId())
                .event(eventType)
                .parameters(createParams(eventType.getCode(), user))
                .build();
    }

    private User createUser(){
        int flag = random.nextInt(100);
        return new User(flag);
    }

    private EventPrams createParams(int eventCode, User user){
        if( eventCode == 1){
            return new HomeEventParams().makeParams(user);
        }
        if( eventCode == 2 ){
            return new LoginEventParams().makeParams(user);
        }
        if( eventCode == 3 ){
            return new PostLookupEventParams().makeParams(createPost());
        }
        if( eventCode == 4 ){
            return new PostListLookupEventParams().makeParams();
        }
        return createParams(new Random().nextInt(4), user);
    }

    private Post createPost(){
        int flag = random.nextInt(100);
        return Post.builder()
                .id(flag)
                .title("POST_TITLE"+flag)
                .category(Category.radomCategory())
                .build();
    }
}
