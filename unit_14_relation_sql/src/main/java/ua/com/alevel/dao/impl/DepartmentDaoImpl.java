package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static ua.com.alevel.consts.ConnectionConst.*;

public class DepartmentDaoImpl implements DepartmentDao {

    private final Connection connection;

    public DepartmentDaoImpl() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(Department entity) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO departments VALUES (default, ?)")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Department entity) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("UPDATE departments SET name = ? WHERE id = ?")) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setLong(2, entity.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    * Remember -> remove from dep_emp
    * **/
    @Override
    public void delete(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM departments WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Department> findById(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM departments WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return Optional.of(getDepartmentFromResultSet(rs));
            }
            return Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Collection<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM departments")) {
            while (resultSet.next()) {
                departments.add(getDepartmentFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return departments;
    }

    private Department getDepartmentFromResultSet(ResultSet resultSet) throws SQLException {
        Department department = new Department();
        department.setId(resultSet.getLong("id"));
        department.setName(resultSet.getString("name"));
        return department;
    }
}
