package ua.com.alevel.persistence.type;

import lombok.Getter;

@Getter
public enum ColorType {

    SPACE_BLACK("Space Black"),
    SPACE_GRAY("Space Gray"),
    SILVER("Silver");

    private final String color;

    ColorType(String color) {
        this.color = color;
    }
}
