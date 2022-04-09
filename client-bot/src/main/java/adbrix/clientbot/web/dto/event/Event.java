package adbrix.clientbot.web.dto.event;

import adbrix.clientbot.web.dto.event.prams.EventPrams;
import adbrix.clientbot.web.util.EventType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class Event {

    private int eventId;
    private String userId;
    private EventType event;
    private EventPrams parameters;
    private LocalDateTime createDateTime;
}
