package com.kolesnyk;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootApplication
public class NftApplication {

    public static void main(String[] args) {
        SpringApplication.run(NftApplication.class, args);
    }

    @Bean
    public DataSource dataSource() throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("jpaTest");
        dataSource.setServerName("localhost");
        dataSource.setPort(3306);
        dataSource.setUser("root");
        dataSource.setPassword("password");
        dataSource.setServerTimezone("UTC");
        return dataSource;
    }

}
