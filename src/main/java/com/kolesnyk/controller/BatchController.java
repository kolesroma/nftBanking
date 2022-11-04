package com.kolesnyk.controller;

import com.kolesnyk.dto.BatchCreationDto;
import com.kolesnyk.dto.BatchDto;
import com.kolesnyk.service.BatchService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Collection;

@RestController
@RequestMapping("/nft/batches")
@Validated
public class BatchController {
    private final BatchService batchService;

    public BatchController(BatchService batchService) {
        this.batchService = batchService;
    }

    @PostMapping
    public void createBatch(@Valid @RequestBody BatchCreationDto batchDto) {
        batchService.saveBatch(batchDto);
    }

    @GetMapping("/{batchId}")
    public BatchDto getBatchById(@PathVariable int batchId) {
        return batchService.getById(batchId);
    }

    @GetMapping
    public Collection<BatchDto> getBatchesOnPage(@RequestParam @Min(0) int page,
                                                 @RequestParam @Min(0) @Max(100) int size) {
        return batchService.getAllProducts(page, size);
    }

    @PutMapping("/{batchId}")
    public void updateBatch(@Valid @RequestBody BatchCreationDto batchDto, @PathVariable int batchId) {
        batchService.updateBatch(batchDto, batchId);
    }

    @DeleteMapping("/{batchId}")
    public void deleteBatch(@PathVariable int batchId) {
        batchService.deleteBatch(batchId);
    }
}
