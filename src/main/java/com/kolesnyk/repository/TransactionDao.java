package com.kolesnyk.repository;

import com.kolesnyk.model.TransactionEntity;

public interface TransactionDao {
    void update(TransactionEntity transaction, int id);
}
