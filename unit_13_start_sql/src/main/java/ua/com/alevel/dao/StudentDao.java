package ua.com.alevel.dao;

import ua.com.alevel.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private final Connection connection;

    public StudentDao() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_11_online",
                    "root",
                    "Test123!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createStudent(Student student) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("INSERT INTO students VALUES (default, ?, ?, ?)")) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStudent(Student student) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("UPDATE students SET first_name = ?, last_name = ?, age = ? WHERE id = ?")) {
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.setLong(4, student.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteStudent(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("DELETE FROM students WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Student getStudentById(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement("SELECT * FROM students WHERE id = ?")) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return getStudentFromResultSet(rs);
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM students")) {
            while (resultSet.next()) {
                students.add(getStudentFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    private Student getStudentFromResultSet(ResultSet resultSet) throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getLong("id"));
        student.setFirstName(resultSet.getString("first_name"));
        student.setLastName(resultSet.getString("last_name"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}
