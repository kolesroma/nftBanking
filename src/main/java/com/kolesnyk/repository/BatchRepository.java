package com.kolesnyk.repository;

import com.kolesnyk.model.Batch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BatchRepository extends PagingAndSortingRepository<Batch, Integer> {
}
