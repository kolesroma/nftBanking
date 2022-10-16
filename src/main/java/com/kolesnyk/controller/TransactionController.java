package com.kolesnyk.controller;

import com.kolesnyk.dto.TransactionCreationDto;
import com.kolesnyk.dto.TransactionDto;
import com.kolesnyk.service.TransactionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Collection;

@RestController
@RequestMapping("/nft/transactions")
@Validated
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public void createTransaction(@Valid @RequestBody TransactionCreationDto transactionDto) {
        transactionService.saveTransaction(transactionDto);
    }

    @GetMapping("/{transactionId}")
    public TransactionDto getTransactionById(@PathVariable int transactionId) {
        return transactionService.getById(transactionId);
    }

    @GetMapping
    public Collection<TransactionDto> getAllTransactions(@RequestParam @Min(0) int page,
                                                         @RequestParam @Min(1) @Max(100) int size) {
        return transactionService.getAllTransactions(page, size);
    }

    @PutMapping("/{transactionId}")
    public void updateTransaction(@Valid @RequestBody TransactionCreationDto transactionDto,
                                   @PathVariable int transactionId) {
        transactionService.updateTransaction(transactionDto, transactionId);
    }

    @DeleteMapping("/{transactionId}")
    public void deleteTransaction(@PathVariable int transactionId) {
        transactionService.deleteTransaction(transactionId);
    }
}
