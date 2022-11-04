package com.kolesnyk;

import com.kolesnyk.model.TransactionEntity;
import com.kolesnyk.repository.TransactionDao;
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
            TransactionEntity transaction = new TransactionEntity();
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
