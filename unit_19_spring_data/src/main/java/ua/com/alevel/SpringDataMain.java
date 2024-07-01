package ua.com.alevel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.com.alevel.controller.MainController;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.repository.EmployeeRepository;
import ua.com.alevel.service.DepartmentService;

import java.util.Collection;
import java.util.List;

public class SpringDataMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.scan("ua.com.alevel");
        applicationContext.refresh();

//        MainController controller = applicationContext.getBean(MainController.class);
//        controller.start();

        DepartmentService departmentService = applicationContext.getBean(DepartmentService.class);

//        departmentService.delete(5L);
//        departmentService.deleteByNameContainingIgnoreCase("m");
//        departmentService.deleteByNameEndingWithIgnoreCase("s");

        EmployeeRepository employeeRepository = applicationContext.getBean(EmployeeRepository.class);

//        Collection<Employee> employees = employeeRepository.findAllByFirstNameStartingWithIgnoreCaseAndLastNameContainingIgnoreCaseOrAgeBetween("", "", 19, 21);
//        Collection<Employee> employees = employeeRepository.findAllByDepartmentsNameIgnoreCase("java");
        Collection<Employee> employees = employeeRepository.findAllByDepartmentsNameIgnoreCaseIn(List.of("java", "js"));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
