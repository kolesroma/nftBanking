package com.kolesnyk.repository;

import com.kolesnyk.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class TransactionDaoImpl implements TransactionDao {
    private final DataSource dataSource;

    public TransactionDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void update(Transaction transaction, int id) {
        String sql = "update nft.transaction set amount = ? where id = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        int out = jdbcTemplate.update(sql, transaction.getAmount(), id);
        if (out == 0) System.out.println("no upd :(");
    }
}
