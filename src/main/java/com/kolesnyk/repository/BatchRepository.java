package com.kolesnyk.repository;

import com.kolesnyk.model.BatchEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends PagingAndSortingRepository<BatchEntity, Integer> {
}
