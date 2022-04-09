package adbrix.clientbot.web.dto.event.prams;

import adbrix.clientbot.web.dto.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class HomeEventParams implements EventPrams{

    private LocalDateTime connetDateTime;

    @Override
    public EventPrams makeParams(User user) {
        this.connetDateTime = LocalDateTime.now();
        return this;
    }

    public EventPrams makeParams(){
        this.connetDateTime = LocalDateTime.now();
        return this;
    }
}
