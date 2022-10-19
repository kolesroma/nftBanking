package com.kolesnyk.repository;

import com.kolesnyk.model.Transaction;

public interface TransactionDao {
    void update(Transaction transaction, int id);
}
