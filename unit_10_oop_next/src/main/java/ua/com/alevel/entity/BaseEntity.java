package ua.com.alevel.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// data class
@Getter
@Setter
@EqualsAndHashCode
public abstract class BaseEntity {

    private String id;
    private Date created;
    private Date updated;
}
