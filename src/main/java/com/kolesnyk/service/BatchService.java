package com.kolesnyk.service;

import com.kolesnyk.dto.BatchCreationDto;
import com.kolesnyk.model.Batch;

import java.util.Collection;
import java.util.Optional;

public interface BatchService {
    void saveBatch(BatchCreationDto batchDto);

    Optional<Batch> getById(int id);

    Collection<Batch> getAllProducts(int page, int size);

    void updateBatch(BatchCreationDto batchDto, int id);

    void deleteBatch(int id);
}
