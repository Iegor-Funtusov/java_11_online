package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static ua.com.alevel.consts.ConnectionConst.*;

public class EmployeeDaoImpl implements EmployeeDao {

    private final Connection connection;

    public EmployeeDaoImpl() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Employee entity) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO employees VALUES (default, ?, ?, ?)")) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setInt(3, entity.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Employee entity) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("UPDATE employees SET first_name = ?, last_name = ?, age = ? WHERE id = ?")) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setInt(3, entity.getAge());
            preparedStatement.setLong(4, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    * use this code if 'on delete cascade' is not set
    * **/
    @Override
    public void delete(Long id) {
        try (PreparedStatement preparedStatement1 =
                     connection.prepareStatement("DELETE FROM dep_emp WHERE emp_id = ?");
             PreparedStatement preparedStatement2 =
                     connection.prepareStatement("DELETE FROM employees WHERE id = ?")
        ) {
            preparedStatement1.setLong(1, id);
            preparedStatement1.executeUpdate();
            preparedStatement2.setLong(1, id);
            preparedStatement2.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Employee> findById(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM employees WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(getEmployeeFromResultSet(rs));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM employees")) {
            while (resultSet.next()) {
                employees.add(getEmployeeFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public Collection<Employee> findAllByDepartment(Long departmentId) {
        List<Employee> employees = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(
                             "SELECT id, first_name, last_name, age " +
                                     "FROM employees AS emp " +
                                     "LEFT JOIN dep_emp AS de ON emp.id = de.emp_id " +
                                     "WHERE dep_id = ?")) {
            preparedStatement.setLong(1, departmentId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                employees.add(getEmployeeFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employees;
    }

    @Override
    public void addEmployeeToDepartment(Long employeeId, Long departmentId) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO dep_emp VALUES (?, ?)")) {
            preparedStatement.setLong(1, departmentId);
            preparedStatement.setLong(2, employeeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEmployeeFromDepartment(Long employeeId, Long departmentId) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM dep_emp WHERE dep_id = ? AND emp_id = ?")) {
            preparedStatement.setLong(1, departmentId);
            preparedStatement.setLong(2, employeeId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Employee getEmployeeFromResultSet(ResultSet resultSet) throws SQLException {
        Employee employee = new Employee();
        employee.setId(resultSet.getLong("id"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setAge(resultSet.getInt("age"));
        return employee;
    }
}
