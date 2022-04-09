package adbrix.clientbot.web.dto.post;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class Post {

    private int id;
    private String title;
    private Category category;
}
