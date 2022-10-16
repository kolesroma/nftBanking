package com.kolesnyk.dto;

import com.kolesnyk.model.Batch;
import com.kolesnyk.model.Product;
import com.kolesnyk.model.User;
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

    private Product product;

    private User user;

    private Batch batch;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;
}
