package adbrix.clientbot.service;

import adbrix.clientbot.web.dto.event.EventResult;
import adbrix.clientbot.web.util.EventType;

public interface EventService {
    EventResult execute(EventType eventCode);
}
