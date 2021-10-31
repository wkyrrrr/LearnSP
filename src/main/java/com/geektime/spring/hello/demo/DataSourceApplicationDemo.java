package com.geektime.spring.hello.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author abner
 */
//@SpringBootApplication
@Slf4j
public class DataSourceApplicationDemo implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

//    public static void main(String[] args) {
//        SpringApplication.run(DataSourceApplicationDemo.class, args);
//    }

    @Override
    public void run(String... args) throws Exception {
        showConnection();
    }

    private void showConnection() throws SQLException {
        log.info(dataSource.toString());
        Connection connection = dataSource.getConnection();
        log.info(connection.toString());
        connection.close();
    }
}
