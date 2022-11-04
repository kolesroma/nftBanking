package com.kolesnyk.service.impl;

import com.kolesnyk.dto.TransactionCreationDto;
import com.kolesnyk.dto.TransactionDto;
import com.kolesnyk.dto.mapper.TransactionMapper;
import com.kolesnyk.exception.TransactionNotFound;
import com.kolesnyk.model.TransactionEntity;
import com.kolesnyk.repository.TransactionRepository;
import com.kolesnyk.service.TransactionService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionMapper mapper;

    public TransactionServiceImpl(TransactionRepository transactionRepository, TransactionMapper mapper) {
        this.transactionRepository = transactionRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveTransaction(TransactionCreationDto transactionDto) {
        transactionRepository.save(mapper.toTransaction(transactionDto));
    }

    @Override
    public TransactionDto getById(int id) {
        TransactionEntity transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new TransactionNotFound("there is no transaction with id " + id));
        return mapper.toDto(transaction);
    }

    @Override
    public Collection<TransactionDto> getAllTransactions(int page, int size) {
        return transactionRepository.findAll(PageRequest.of(page, size))
                .map(mapper::toDto)
                .getContent();
    }

    // open transaction cuz of 2 DB req ??
    @Override
    public void updateTransaction(TransactionCreationDto transactionDto, int transactionId) {
        if (!transactionRepository.existsById(transactionId))
            throw new TransactionNotFound("there is no transaction with id " + transactionId);
        TransactionEntity transaction = mapper.toTransaction(transactionDto);
        transaction.setId(transactionId);
        transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransaction(int transactionId) {
        if (!transactionRepository.existsById(transactionId))
            throw new TransactionNotFound("there is no transaction with id " + transactionId);
        transactionRepository.deleteById(transactionId);
    }
}
