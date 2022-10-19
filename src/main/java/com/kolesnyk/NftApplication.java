package com.kolesnyk;

import com.kolesnyk.model.Transaction;
import com.kolesnyk.repository.TransactionDao;
import com.kolesnyk.repository.TransactionDaoImpl;
import com.kolesnyk.repository.UserRepository;
import com.kolesnyk.model.User;
import com.kolesnyk.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class NftApplication {

    public static void main(String[] args) {
        SpringApplication.run(NftApplication.class, args);
    }

    @Bean
    CommandLineRunner sd(TransactionDao transactionDao) {
        return args -> {
            Transaction transaction = new Transaction();
            transaction.setAmount(3299);
            transactionDao.update(transaction, 4);
        };
    }

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/nft")
                .username("root")
                .password("password")
                .build();
    }

}
