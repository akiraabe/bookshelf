package org.work;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by akiraabe on 2017-06-19.
 */
public class TestDataSourceConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/bookshelf";
    private static final String USERNAME = "bookshelf";
    private static final String PASSWORD = "bookshelf";

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(URL, USERNAME, PASSWORD);
    }
}
