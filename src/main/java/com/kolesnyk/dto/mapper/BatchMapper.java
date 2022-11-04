package com.kolesnyk.dto.mapper;

import com.kolesnyk.dto.BatchCreationDto;
import com.kolesnyk.dto.BatchDto;
import com.kolesnyk.model.BatchEntity;
import org.springframework.stereotype.Component;

@Component
public class BatchMapper {
    public BatchEntity toBatch(BatchCreationDto batchDto) {
        return BatchEntity.builder()
                .id(0)
                .comment(batchDto.getComment())
                .priority(batchDto.getPriority())
                .createdAt(batchDto.getCreatedAt())
                .updatedAt(batchDto.getUpdatedAt())
                .status(batchDto.isStatus())
                .build();
    }

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
