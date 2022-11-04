package com.kolesnyk.dto.mapper;

import com.kolesnyk.dto.TransactionCreationDto;
import com.kolesnyk.dto.TransactionDto;
import com.kolesnyk.model.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public TransactionEntity toTransaction(TransactionCreationDto transactionDto) {
        return TransactionEntity.builder()
                .id(0)
                .amount(transactionDto.getAmount())
                .product(transactionDto.getProduct())
                .user(transactionDto.getUser())
                .batch(transactionDto.getBatch())
                .createdAt(transactionDto.getCreatedAt())
                .updatedAt(transactionDto.getUpdatedAt())
                .build();
    }

    public TransactionDto toDto(TransactionEntity transaction) {
        return TransactionDto.builder()
                .id(transaction.getId())
                .amount(transaction.getAmount())
                .product(transaction.getProduct())
                .user(transaction.getUser())
                .batch(transaction.getBatch())
                .createdAt(transaction.getCreatedAt())
                .updatedAt(transaction.getUpdatedAt())
                .build();
    }
}
