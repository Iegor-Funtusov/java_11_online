package ua.com.alevel.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.alevel.entity.Department;

public interface DepartmentRepository extends BaseRepository<Department> {

    boolean existsByName(String name);

    void deleteByNameEndingWithIgnoreCase(String name);
    void deleteByNameContainingIgnoreCase(String name);

    @Query("select d from Department d where d.name = :name")
//    @Query("delete from Department d where d.name like '%:name'")
    boolean wantToCheckExistDepartmentByName(@Param("name") String name);
}
