package ua.com.alevel.dto.res;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.entity.Department;

@Getter
@Setter
public class DepartmentResDto extends BaseResDto {

    private String name;

    public DepartmentResDto(Department department) {
        setId(department.getId());
        setCreated(department.getCreated());
        setUpdated(department.getUpdated());
        setName(department.getName());
    }
}
