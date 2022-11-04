package com.kolesnyk.mapper.impl;

import com.kolesnyk.dto.BatchCreationDto;
import com.kolesnyk.dto.BatchDto;
import com.kolesnyk.mapper.GeneralMapper;
import com.kolesnyk.model.BatchEntity;
import org.springframework.stereotype.Component;

@Component
public class BatchMapper implements GeneralMapper<BatchEntity, BatchCreationDto, BatchDto> {
    @Override
    public BatchEntity toEntity(BatchCreationDto batchDto) {
        return BatchEntity.builder()
                .id(0)
                .comment(batchDto.getComment())
                .priority(batchDto.getPriority())
                .createdAt(batchDto.getCreatedAt())
                .updatedAt(batchDto.getUpdatedAt())
                .status(batchDto.isStatus())
                .build();
    }

    @Override
    public BatchDto toDto(BatchEntity batch) {
        return BatchDto.builder()
                .id(batch.getId())
                .comment(batch.getComment())
                .priority(batch.getPriority())
                .createdAt(batch.getCreatedAt())
                .updatedAt(batch.getUpdatedAt())
                .status(batch.isStatus())
                .build();
    }
}
