package com.kolesnyk.repository.impl;

import com.kolesnyk.model.BatchEntity;
import com.kolesnyk.model.ProductEntity;
import com.kolesnyk.model.TransactionEntity;
import com.kolesnyk.model.UserEntity;
import com.kolesnyk.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class TransactionDaoImpl implements TransactionRepository {
    private final JdbcTemplate jdbcTemplate;

    private static final String SAVE_TRANSACTION = "replace into transaction(id, amount, created_at, updated_at, batch_id, product_id, user_id) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_TRANSACTION = "select t.id, t.amount, t.created_at, t.updated_at, t.batch_id, t.product_id, t.user_id," +
            "       b.comment, b.priority, b.created_at, b.updated_at, b.status," +
            "       p.description, p.short_name, p.price, p.full_name, p.upc," +
            "       u.username, u.phone, u.email, u.balance, u.enabled " +
            "from transaction as t" +
            "         join nft.batch b on b.id = t.batch_id" +
            "         join nft.product p on p.id = t.product_id" +
            "         join nft.user u on u.id = t.user_id " +
            "where t.id = ? limit 1";


    public TransactionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<TransactionEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<TransactionEntity> findAll(Pageable pageable) {
        return null;
    }


    /**
     * use id for creating a new row in database (like PUT method: create or update by id)
     *
     * @param transaction all entity to be written
     * @return this transaction
     */
    @Override
    public <S extends TransactionEntity> S save(S transaction) {
        jdbcTemplate.update(SAVE_TRANSACTION, transaction.getId(), transaction.getAmount(),
                transaction.getCreatedAt(), transaction.getUpdatedAt(), transaction.getBatch().getId(),
                transaction.getProduct().getId(), transaction.getUser().getId());
        return transaction;
    }

    @Override
    public <S extends TransactionEntity> Iterable<S> saveAll(Iterable<S> transactions) {
        transactions
                .forEach(this::save);
        return transactions;
    }

    @Override
    public Optional<TransactionEntity> findById(Integer integer) {
        List<TransactionEntity> transactions =
                jdbcTemplate.query(SELECT_TRANSACTION, new TransactionRowMapper(), integer);
        if (transactions.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(transactions.get(0));
    }

    class TransactionRowMapper implements RowMapper<TransactionEntity> {
        @Override
        public TransactionEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            return TransactionEntity.builder()
                    .id(rs.getInt("t.id"))
                    .amount(rs.getInt("t.amount"))
                    .createdAt(rs.getTimestamp("t.created_at").toLocalDateTime())
                    .updatedAt(rs.getTimestamp("t.updated_at").toLocalDateTime())
                    .batch(BatchEntity.builder()
                            .id(rs.getInt("t.batch_id"))
                            .comment(rs.getString("b.comment"))
                            .priority(rs.getInt("b.priority"))
                            .createdAt(rs.getTimestamp("b.created_at").toLocalDateTime())
                            .updatedAt(rs.getTimestamp("b.updated_at").toLocalDateTime())
                            .status(rs.getBoolean("b.status"))
                            .build())
                    .product(ProductEntity.builder()
                            .id(rs.getInt("t.product_id"))
                            .description(rs.getString("p.description"))
                            .shortName(rs.getString("p.short_name"))
                            .price(rs.getInt("p.price"))
                            .fullName(rs.getString("p.full_name"))
                            .upc(rs.getString("p.upc"))
                            .build())
                    .user(UserEntity.builder()
                            .id(rs.getInt("t.user_id"))
                            .username(rs.getString("u.username"))
                            .phone(rs.getString("u.phone"))
                            .email(rs.getString("u.email"))
                            .balance(rs.getInt("u.balance"))
                            .enabled(rs.getBoolean("u.enabled"))
                            .build())
                    .build();
        }
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<TransactionEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<TransactionEntity> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {
    }

    @Override
    public void delete(TransactionEntity entity) {
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
    }

    @Override
    public void deleteAll(Iterable<? extends TransactionEntity> entities) {
    }

    @Override
    public void deleteAll() {
    }
}
