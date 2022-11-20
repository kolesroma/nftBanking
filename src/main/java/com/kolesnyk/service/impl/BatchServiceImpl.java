package com.kolesnyk.service.impl;

import com.kolesnyk.dto.creation.BatchCreationDto;
import com.kolesnyk.dto.BatchDto;
import com.kolesnyk.mapper.impl.BatchMapper;
import com.kolesnyk.exception.BatchNotFound;
import com.kolesnyk.model.BatchEntity;
import com.kolesnyk.repository.BatchRepository;
import com.kolesnyk.service.BatchService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@AllArgsConstructor
public class BatchServiceImpl implements BatchService {
    private final BatchRepository batchRepository;
    private final BatchMapper mapper;

    @Override
    public void saveBatch(BatchCreationDto batchDto) {
        batchRepository.save(mapper.toEntity(batchDto));
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
    @Transactional
    public void updateBatch(BatchCreationDto batchDto, int id) {
        if (!batchRepository.existsById(id)) {
            throw new BatchNotFound("there is no batch with id " + id);
        }
        BatchEntity batch = mapper.toEntity(batchDto);
        batch.setId(id);
        batchRepository.save(batch);
    }

    @Override
    @Transactional
    public void deleteBatch(int id) {
        if (!batchRepository.existsById(id)) {
            throw new BatchNotFound("there is no batch with id " + id);
        }
        batchRepository.deleteById(id);
    }
}
