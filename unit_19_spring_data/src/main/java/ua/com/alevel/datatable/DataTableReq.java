package ua.com.alevel.datatable;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class DataTableReq extends DataTable {
    private Map<String, String> filters;
}
