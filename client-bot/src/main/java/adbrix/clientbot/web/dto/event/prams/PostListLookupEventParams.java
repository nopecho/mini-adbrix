package adbrix.clientbot.web.dto.event.prams;

import adbrix.clientbot.web.dto.post.Category;
import adbrix.clientbot.web.dto.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PostListLookupEventParams implements EventPrams{

    private Category category;

    @Override
    public EventPrams makeParams(User user) {
        return null;
    }

    public EventPrams makeParams(){
        this.category = Category.radomCategory();
        return this;
    }
}
