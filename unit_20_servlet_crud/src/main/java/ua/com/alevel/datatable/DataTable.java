package ua.com.alevel.datatable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DataTable {
    private int currentPage;
    private int pageSize;
    private String sort;
    private Order orderBy;
}
