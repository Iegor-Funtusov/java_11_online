package ua.com.alevel.repository;

import ua.com.alevel.entity.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeRepository extends BaseRepository<Employee> {

    //    findBy/findAllBy
    Collection<Employee> findAllByFirstNameStartingWithIgnoreCaseAndLastNameContainingIgnoreCaseOrAgeBetween(String firstName, String lastName, int left, int right);
    Collection<Employee> findAllByDepartmentsNameIgnoreCase(String departmentsName);
    Collection<Employee> findAllByDepartmentsNameIgnoreCaseIn(List<String> departmentsName);

    //    deleteBy/deleteAllBy
    void deleteAllByFirstNameStartingWithIgnoreCase(String firstName);

    //    countBy/countAllBy
    long countAllByFirstNameStartingWithIgnoreCase(String firstName);

    //    existsBy/existsAllBy
    boolean existsAllByFirstNameAndLastNameStartingWithIgnoreCase(String firstName, String lastName);
}
