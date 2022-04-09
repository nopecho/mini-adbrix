package adbrix.clientbot.web.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventType {
    HOME(1),
    LOGIN(2),
    GET_POST(3),
    GET_POST_LIST(4),
    RANDOM(0);

    private final int code;
}
