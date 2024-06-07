package ua.com.alevel;

import java.sql.*;
import java.util.List;

public class TableGenerator {

    private final Connection connection;

    public TableGenerator() {
        try {
            this.connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_11", "root", "Test123!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateTables(List<String> queries) {
        for (String query : queries) {
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement(query)) {
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
