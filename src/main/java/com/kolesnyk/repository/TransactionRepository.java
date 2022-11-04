package com.kolesnyk.repository;

import com.kolesnyk.model.TransactionEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends PagingAndSortingRepository<TransactionEntity, Integer> {
}
