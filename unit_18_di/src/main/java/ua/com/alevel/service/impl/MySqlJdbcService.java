package ua.com.alevel.service.impl;

import ua.com.alevel.annotations.Service;
import ua.com.alevel.service.JdbcService;

import java.sql.Connection;

@Service
public class MySqlJdbcService implements JdbcService {

    @Override
    public Connection getConnection() {
        return null;
    }
}
