package com.kolesnyk.dto;

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
}
