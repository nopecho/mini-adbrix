package adbrix.clientbot.web.dto.post;

import java.util.List;
import java.util.Random;

public enum Category {
    QNA, TECH, IT, ETC;

    private static final Random RANDOM = new Random();
    private static final List<Category> CATEGORIES = List.of(values());
    public static Category radomCategory(){
        return CATEGORIES.get(RANDOM.nextInt(CATEGORIES.size()));
    }
}
