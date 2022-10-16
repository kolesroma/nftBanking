package com.kolesnyk.dto.mapper;

import com.kolesnyk.dto.TransactionCreationDto;
import com.kolesnyk.dto.TransactionDto;
import com.kolesnyk.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    public Transaction toTransaction(TransactionCreationDto transactionDto) {
        return Transaction.builder()
                .id(0)
                .amount(transactionDto.getAmount())
                .product(transactionDto.getProduct())
                .user(transactionDto.getUser())
                .batch(transactionDto.getBatch())
                .createdAt(transactionDto.getCreatedAt())
                .updatedAt(transactionDto.getUpdatedAt())
                .build();
    }

    public TransactionDto toDto(Transaction transaction) {
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
