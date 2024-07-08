package ua.com.alevel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.EmployeeService;
import ua.com.alevel.service.impl.EmployeeServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

public class EmployeeListController extends HttpServlet {

    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Collection<Employee> employees = employeeService.findAll();

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Hello World</title>");
        writer.println("</head>");
        writer.println("<body>");
        if (CollectionUtils.isNotEmpty(employees)) {
            writer.println("<table>");
            writer.println("<tr>");
            writer.println("<th>Id</th>");
            writer.println("<th>First name</th>");
            writer.println("<th>Last name</th>");
            writer.println("<th>Age</th>");
            writer.println("</tr>");
            for (Employee employee : employees) {
                writer.println("<tr>");
                writer.println("<td>" + employee.getId() + "</td>");
                writer.println("<td>" + employee.getFirstName() + "</td>");
                writer.println("<td>" + employee.getLastName() + "</td>");
                writer.println("<td>" + employee.getAge() + "</td>");
                writer.println("</tr>");
            }
            writer.println("</table>");
        }
        writer.println("</body>");
        writer.println("<br>");
        writer.println("<a href=\"/unit_20_servlet_crud/employees/create\">New employee</a>");
        writer.println("</html>");
    }
}
