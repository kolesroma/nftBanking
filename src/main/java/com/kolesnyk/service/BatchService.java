package com.kolesnyk.service;

import com.kolesnyk.dto.creation.BatchCreationDto;
import com.kolesnyk.dto.BatchDto;

import java.util.Collection;

public interface BatchService {
    void saveBatch(BatchCreationDto batchDto);

    BatchDto getById(int id);

    Collection<BatchDto> getAllProducts(int page, int size);

    void updateBatch(BatchCreationDto batchDto, int id);

    void deleteBatch(int id);
}
