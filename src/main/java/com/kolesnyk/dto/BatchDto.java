package com.kolesnyk.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BatchDto {
    private int id;

    private String comment;

    private int priority;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private boolean status;
}
