package com.kolesnyk.dto.mapper;

import com.kolesnyk.dto.BatchCreationDto;
import com.kolesnyk.dto.BatchDto;
import com.kolesnyk.model.Batch;
import org.springframework.stereotype.Component;

@Component
public class BatchMapper {
    public Batch toBatch(BatchCreationDto batchDto) {
        return Batch.builder()
                .id(0)
                .comment(batchDto.getComment())
                .priority(batchDto.getPriority())
                .createdAt(batchDto.getCreatedAt())
                .updatedAt(batchDto.getUpdatedAt())
                .status(batchDto.isStatus())
                .build();
    }

    public BatchDto toDto(Batch batch) {
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
