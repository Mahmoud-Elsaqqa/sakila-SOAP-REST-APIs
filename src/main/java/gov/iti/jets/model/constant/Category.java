package gov.iti.jets.model.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Category {
    NONE(0, "-"),
    ACTION(1, "Action"),
    ANIMATION(2, "Animation"),
    CHILDREN(3, "Children"),
    CLASSICS(4, "Classics"),
    COMEDY(5, "Comedy"),
    DOCUMENTARY(6, "Documentary"),
    DRAMA(7, "Drama"),
    FAMILY(8, "Family"),
    FOREIGN(9, "Foreign"),
    GAMES(10, "Games"),
    HORROR(11, "Horror"),
    MUSIC(12, "Music"),
    NEW(13, "New"),
    SCI_FI(14, "Sci-Fi"),
    SPORTS(15, "Sports"),
    TRAVEL(16, "Travel");

    private final Integer id;
    private final String category;

    public static Category getCategoryById(Integer id) {
        return Objects.requireNonNull(Stream.of(Category.values())
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null));
    }

    public String getCategory() {
        return category;
    }
}
