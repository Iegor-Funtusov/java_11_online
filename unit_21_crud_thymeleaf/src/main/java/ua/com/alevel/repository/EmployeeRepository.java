package ua.com.alevel.repository;

import org.springframework.data.jpa.repository.Query;
import ua.com.alevel.entity.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository extends BaseRepository<Employee> {

    //    findBy/findAllBy
//    Collection<Employee> findAllByFirstNameStartingWithIgnoreCaseAndLastNameContainingIgnoreCaseOrAgeBetween(String firstName, String lastName, int left, int right);
    Collection<Employee> findAllByDepartmentsNameIgnoreCase(String departmentsName);
    Collection<Employee> findAllByDepartmentsNameIgnoreCaseIn(List<String> departmentsName);

    @Query(value = "select * from employees where id not in(\n" +
            "    select emp_id from employees left join dep_emp de on employees.id = de.emp_id where dep_id = ?" +
            "    )", nativeQuery = true)
    List<Employee> findAllEmployeesNotExistsInDepartment(Long id);

    //    deleteBy/deleteAllBy
    void deleteAllByFirstNameStartingWithIgnoreCase(String firstName);

    //    countBy/countAllBy
    long countAllByFirstNameStartingWithIgnoreCase(String firstName);

    //    existsBy/existsAllBy
    boolean existsAllByFirstNameAndLastNameStartingWithIgnoreCase(String firstName, String lastName);
}
