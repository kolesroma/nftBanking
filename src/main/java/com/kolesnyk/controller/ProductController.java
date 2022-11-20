package com.kolesnyk.controller;

import com.kolesnyk.dto.ProductCreationDto;
import com.kolesnyk.dto.ProductDto;
import com.kolesnyk.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Collection;

@RestController
@RequestMapping("/nft/products")
@Validated
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public void createProduct(@Valid @RequestBody ProductCreationDto productDto) {
        productService.saveProduct(productDto);
    }

    @GetMapping("/{productId}")
    public ProductDto getProductById(@PathVariable int productId) {
        return productService.getById(productId);
    }

    @GetMapping
    public Collection<ProductDto> getProductsOnPage(@RequestParam @Min(0) int page,
                                                    @RequestParam @Min(0) @Max(100) int size) {
        return productService.getAllProducts(page, size);
    }

    @PutMapping("/{productId}")
    public void updateProduct(@Valid @RequestBody ProductCreationDto productDto, @PathVariable int productId) {
        productService.updateProduct(productDto, productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable int productId) {
        productService.deleteProduct(productId);
    }
}
