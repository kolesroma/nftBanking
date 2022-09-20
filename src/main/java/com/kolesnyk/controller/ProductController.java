package com.kolesnyk.controller;

import com.kolesnyk.dto.ProductCreationDto;
import com.kolesnyk.exception.EntityNotFound;
import com.kolesnyk.model.Product;
import com.kolesnyk.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Collection;

@RestController
@RequestMapping("/nft/products")
@Validated
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public void createProduct(@Valid @RequestBody ProductCreationDto productDto) {
        productService.saveProduct(productDto);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable int productId) {
        return ResponseEntity.of(productService.getById(productId));
    }

    @GetMapping
    public Collection<Product> getProductsOnPage(@RequestParam @Min(0) int page,
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({EntityNotFound.class, ConstraintViolationException.class})
    public String entityValidation(RuntimeException e) {
        return e.getMessage();
    }
}
