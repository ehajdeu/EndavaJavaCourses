package com.euniversity.jdbc.datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class LocalDataSource {

    private final String URL = "jdbc:postgresql://localhost:5432/student_db";
    private final String USER = "postgres";
    private final String DRIVER = "org.postgresql.Driver";
    private final String PASSWORD = "postgres";

    @Bean
    public DataSource getSingletonDatasource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(URL);
        driverManagerDataSource.setUsername(USER);
        driverManagerDataSource.setPassword(PASSWORD);
        driverManagerDataSource.setDriverClassName(DRIVER);
        return driverManagerDataSource;
    }
}
