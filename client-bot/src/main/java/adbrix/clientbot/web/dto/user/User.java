package adbrix.clientbot.web.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter @Setter
public class User {

    private final Random random = new Random();
    private String id;
    private String loginId;
    private String name;
    private int age;

    public User(int flag){
        this.id = "USER_"+flag;
        this.name = "USER_NAME"+flag;
        this.loginId = "LOGIN_"+flag;
        this.age = random.nextInt(30);
    }
}
