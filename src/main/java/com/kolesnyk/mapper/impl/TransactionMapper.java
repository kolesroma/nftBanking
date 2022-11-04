package com.kolesnyk.mapper.impl;

import com.kolesnyk.dto.TransactionCreationDto;
import com.kolesnyk.dto.TransactionDto;
import com.kolesnyk.mapper.GeneralMapper;
import com.kolesnyk.model.TransactionEntity;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper implements GeneralMapper<TransactionEntity, TransactionCreationDto, TransactionDto> {
    @Override
    public TransactionEntity toEntity(TransactionCreationDto transactionDto) {
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

    @Override
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
