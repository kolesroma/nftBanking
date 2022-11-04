package com.kolesnyk.service.impl;

import com.kolesnyk.dto.BatchCreationDto;
import com.kolesnyk.dto.BatchDto;
import com.kolesnyk.dto.mapper.BatchMapper;
import com.kolesnyk.exception.BatchNotFound;
import com.kolesnyk.model.BatchEntity;
import com.kolesnyk.repository.BatchRepository;
import com.kolesnyk.service.BatchService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BatchServiceImpl implements BatchService {
    private final BatchRepository batchRepository;
    private final BatchMapper mapper;

    public BatchServiceImpl(BatchRepository batchRepository, BatchMapper mapper) {
        this.batchRepository = batchRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveBatch(BatchCreationDto batchDto) {
        batchRepository.save(mapper.toBatch(batchDto));
    }

    @Override
    public BatchDto getById(int id) {
        BatchEntity batch = batchRepository.findById(id)
                .orElseThrow(() -> new BatchNotFound("there is no batch with id " + id));
        return mapper.toDto(batch);
    }

    @Override
    public Collection<BatchDto> getAllProducts(int page, int size) {
        return batchRepository.findAll(PageRequest.of(page, size))
                .map(mapper::toDto)
                .getContent();
    }

    @Override
    public void updateBatch(BatchCreationDto batchDto, int id) {
        if (!batchRepository.existsById(id))
            throw new BatchNotFound("there is no batch with id " + id);
        BatchEntity batch = mapper.toBatch(batchDto);
        batch.setId(id);
        batchRepository.save(batch);
    }

    @Override
    public void deleteBatch(int id) {
        if (!batchRepository.existsById(id))
            throw new BatchNotFound("there is no batch with id " + id);
        batchRepository.deleteById(id);
    }
}
