package adbrix.clientbot.web.dto.event.prams;

import adbrix.clientbot.web.dto.post.Category;
import adbrix.clientbot.web.dto.post.Post;
import adbrix.clientbot.web.dto.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class PostListLookupEventParams implements EventPrams{

    private Category lookupCategory;

    @Override
    public EventPrams makeParams(User user) {
        return null;
    }

    public EventPrams makeParams(){
        this.lookupCategory = Category.radomCategory();
        return this;
    }
}
