package ua.com.alevel.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.MapUtils;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.EmployeeService;
import ua.com.alevel.service.impl.EmployeeServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class EmployeeCreateController extends HttpServlet {

    private final EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>EmployeeCreateController</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>Create new employee</h1>");
        writer.println("<br>");
        writer.println("<form action=\"/unit_20_servlet_crud/employees/create\" method=\"post\">");
        writer.println("<label for=\"firstName\">First name</label><br>");
        writer.println("<input type=\"text\" id=\"firstName\" name=\"firstName\" placeholder=\"First name\"><br><br>");
        writer.println("<label for=\"lastName\">Last name</label><br>");
        writer.println("<input type=\"text\" id=\"lastName\" name=\"lastName\" placeholder=\"Last name\"><br><br>");
        writer.println("<label for=\"age\">Age</label><br>");
        writer.println("<input type=\"number\" id=\"age\" name=\"age\" placeholder=\"Age\"><br><br>");
        writer.println("<input type=\"submit\" value=\"Create\">");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        if (MapUtils.isNotEmpty(parameterMap)) {
            String firstName = null;
            String lastName = null;
            int age = 0;
            for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
                String key = entry.getKey();
                String[] values = entry.getValue();
                if (key.equals("firstName")) {
                    firstName = values[0];
                }
                if (key.equals("lastName")) {
                    lastName = values[0];
                }
                if (key.equals("age")) {
                    age = Integer.parseInt(values[0]);
                }
            }
            if (firstName != null && lastName != null && age > 0) {
                Employee employee = new Employee();
                employee.setFirstName(firstName);
                employee.setLastName(lastName);
                employee.setAge(age);
                employeeService.save(employee);
            }
        }
        resp.sendRedirect("/unit_20_servlet_crud/employees");
    }
}
