package com.kolesnyk.repository.impl;

import com.kolesnyk.model.BatchEntity;
import com.kolesnyk.model.ProductEntity;
import com.kolesnyk.model.TransactionEntity;
import com.kolesnyk.model.UserEntity;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.Optional;

class TransactionDaoImplTest {
    private final TransactionDaoImpl transactionDao;

    private static DataSource getMySQLDatasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(3306);
        dataSource.setDatabaseName("nft");
        dataSource.setUser("root");
        dataSource.setPassword("password");
        return dataSource;
    }

    public TransactionDaoImplTest() {
        this.transactionDao = new TransactionDaoImpl(new JdbcTemplate(getMySQLDatasource()));
    }

    @Test
    void save() {
        TransactionEntity transaction = getTestTransaction();
        transactionDao.save(transaction);
    }

    private TransactionEntity getTestTransaction() {
        return TransactionEntity.builder()
                .id(77)
                .amount(300)
                .createdAt(LocalDateTime.parse("2022-10-19T20:35:32"))
                .updatedAt(LocalDateTime.parse("2022-10-19T20:35:37"))
                .batch(getTestBatch())
                .product(getTestProduct())
                .user(getTestUser())
                .build();
    }

    private UserEntity getTestUser() {
        return UserEntity.builder()
                .id(44)
                .username("kolesroma")
                .phone("38555")
                .email("artem@ko")
                .balance(10)
                .enabled(false)
                .build();
    }

    private BatchEntity getTestBatch() {
       return BatchEntity.builder()
                .id(20)
                .comment("btch")
                .priority(2)
                .createdAt(LocalDateTime.parse("2022-11-11T13:35:28"))
                .updatedAt(LocalDateTime.parse("2022-11-11T13:35:43"))
                .status(true)
                .build();
    }

    private ProductEntity getTestProduct() {
       return ProductEntity.builder()
                .id(99)
                .description("prod")
                .shortName("toy")
                .fullName("funny toy")
                .price(405)
                .upc("upc code")
                .build();
    }

    @Test
    void findById() {
        Optional<TransactionEntity> transaction = transactionDao.findById(77);
        if (transaction.isEmpty()) {
            Assertions.fail();
        }
        Assertions.assertEquals(transaction.get(), getTestTransaction());
    }
}