package adbrix.clientbot.web.dto.event.prams;

import adbrix.clientbot.web.dto.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class LoginEventParams implements EventPrams{

    private String loginId;
    private String userName;
    private int age;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime loginDateTime;


    @Override
    public EventPrams makeParams(User user) {
        this.loginId = user.getLoginId();
        this.userName = user.getName();
        this.age = user.getAge();
        this.loginDateTime = LocalDateTime.now();
        return this;
    }
}
