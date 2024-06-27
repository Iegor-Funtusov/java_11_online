package ua.com.alevel.service.impl;

import ua.com.alevel.annotations.Config;
import ua.com.alevel.annotations.PostConstruct;
import ua.com.alevel.annotations.Service;
import ua.com.alevel.service.JdbcService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class MySqlJdbcService implements JdbcService {

    @Config("datasource.url")
    private String url;

    @Config("datasource.username")
    private String username;

    @Config("datasource.password")
    private String password;

    private Connection connection;

    @PostConstruct
    private void init() {
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }
}
