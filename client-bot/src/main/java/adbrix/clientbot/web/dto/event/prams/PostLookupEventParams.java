package adbrix.clientbot.web.dto.event.prams;

import adbrix.clientbot.web.dto.post.Category;
import adbrix.clientbot.web.dto.post.Post;
import adbrix.clientbot.web.dto.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PostLookupEventParams implements EventPrams{

    private int postId;
    private String title;
    private Category category;

    @Override
    public EventPrams makeParams(User user) {
        return null;
    }

    public EventPrams makeParams(Post post){
        this.postId = post.getId();
        this.title = post.getTitle();
        this.category = post.getCategory();
        return this;
    }
}
