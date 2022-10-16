package com.kolesnyk.service;

import com.kolesnyk.dto.TransactionCreationDto;
import com.kolesnyk.dto.TransactionDto;

import java.util.Collection;

public interface TransactionService {
    void saveTransaction(TransactionCreationDto transactionDto);

    TransactionDto getById(int id);

    Collection<TransactionDto> getAllTransactions(int page, int size);

    void updateTransaction(TransactionCreationDto transactionDto, int transactionId);

    void deleteTransaction(int transactionId);
}
