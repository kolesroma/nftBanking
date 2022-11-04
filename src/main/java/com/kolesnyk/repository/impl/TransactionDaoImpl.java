//package com.kolesnyk.repository.impl;
//
//import com.kolesnyk.model.TransactionEntity;
//import com.kolesnyk.repository.TransactionRepository;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.util.Optional;
//
//@Repository
//public class TransactionDaoImpl implements TransactionRepository {
//    private final DataSource dataSource;
//
//    public TransactionDaoImpl(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    public void update(TransactionEntity transaction, int id) {
//        String sql = "update nft.transaction set amount = ? where id = ?";
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//
//        int out = jdbcTemplate.update(sql, transaction.getAmount(), id);
//        if (out == 0) System.out.println("no upd :(");
//    }
//
//    //
//    //
//
//
//    @Override
//    public Iterable<TransactionEntity> findAll(Sort sort) {
//        return null;
//    }
//
//    @Override
//    public Page<TransactionEntity> findAll(Pageable pageable) {
//        return null;
//    }
//
//    @Override
//    public <S extends TransactionEntity> S save(S entity) {
//        return null;
//    }
//
//    @Override
//    public <S extends TransactionEntity> Iterable<S> saveAll(Iterable<S> entities) {
//        return null;
//    }
//
//    @Override
//    public Optional<TransactionEntity> findById(Integer integer) {
//        return Optional.empty();
//    }
//
//    @Override
//    public boolean existsById(Integer integer) {
//        return false;
//    }
//
//    @Override
//    public Iterable<TransactionEntity> findAll() {
//        return null;
//    }
//
//    @Override
//    public Iterable<TransactionEntity> findAllById(Iterable<Integer> integers) {
//        return null;
//    }
//
//    @Override
//    public long count() {
//        return 0;
//    }
//
//    @Override
//    public void deleteById(Integer integer) {
//
//    }
//
//    @Override
//    public void delete(TransactionEntity entity) {
//
//    }
//
//    @Override
//    public void deleteAllById(Iterable<? extends Integer> integers) {
//
//    }
//
//    @Override
//    public void deleteAll(Iterable<? extends TransactionEntity> entities) {
//
//    }
//
//    @Override
//    public void deleteAll() {
//
//    }
//}
