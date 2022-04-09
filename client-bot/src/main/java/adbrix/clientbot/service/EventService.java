package adbrix.clientbot.service;

import adbrix.clientbot.web.util.EventType;

public interface EventService {
    void execute(EventType eventCode);
}
