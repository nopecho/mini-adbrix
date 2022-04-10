package adbrix.clientbot.web.util;

import adbrix.clientbot.web.dto.post.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
@AllArgsConstructor
public enum EventType {
    HOME(1),
    LOGIN(2),
    GET_POST(3),
    GET_POST_LIST(4);

    private final int code;
    private static final Random RANDOM = new Random();
    private static final List<EventType> EVENT_TYPES = List.of(values());
    public static EventType radomEvent(){
        return EVENT_TYPES.get(RANDOM.nextInt(EVENT_TYPES.size()));
    }
}
