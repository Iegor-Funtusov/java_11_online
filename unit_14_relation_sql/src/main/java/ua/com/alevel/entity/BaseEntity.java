package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.annotations.PK;

@Getter
@Setter
@ToString
public abstract class BaseEntity {

    @PK
    private Long id;
}
