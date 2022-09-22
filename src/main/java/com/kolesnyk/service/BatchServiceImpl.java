package com.kolesnyk.service;

import com.kolesnyk.dto.BatchCreationDto;
import com.kolesnyk.dto.BatchMapper;
import com.kolesnyk.exception.EntityNotFound;
import com.kolesnyk.model.Batch;
import com.kolesnyk.repository.BatchRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

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
    public Optional<Batch> getById(int id) {
        return batchRepository.findById(id);
    }

    @Override
    public Collection<Batch> getAllProducts(int page, int size) {
        return batchRepository.findAll(PageRequest.of(page, size))
                .getContent();
    }

    @Override
    public void updateBatch(BatchCreationDto batchDto, int id) {
        if (!batchRepository.existsById(id))
            throw new EntityNotFound("there is no batch with id " + id);
        Batch batch = mapper.toBatch(batchDto);
        batch.setId(id);
        batchRepository.save(batch);
    }

    @Override
    public void deleteBatch(int id) {
        if (!batchRepository.existsById(id))
            throw new EntityNotFound("there is no batch with id " + id);
        batchRepository.deleteById(id);
    }
}
