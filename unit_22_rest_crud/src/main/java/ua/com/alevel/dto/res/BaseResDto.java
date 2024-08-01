package ua.com.alevel.dto.res;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class BaseResDto {

    private Long id;
    private Date created;
    private Date updated;
}
