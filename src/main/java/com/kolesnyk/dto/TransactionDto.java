package com.kolesnyk.dto;

import com.kolesnyk.model.BatchEntity;
import com.kolesnyk.model.ProductEntity;
import com.kolesnyk.model.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDto {
    @NotNull
    private int id;

    @NotNull
    private int amount;

    private ProductEntity product;

    private UserEntity user;

    private BatchEntity batch;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;
}
