package ua.com.alevel.datatable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.entity.BaseEntity;

import java.util.Collection;

@Getter
@Setter
@ToString(callSuper = true)
public class DataTableRes<E extends BaseEntity> extends DataTable {

    @ToString.Exclude
    private Collection<E> items;
    private boolean previous;
    private boolean next;
    private boolean first;
    private boolean last;
    private long totalItems;
    private int totalPages;
}
