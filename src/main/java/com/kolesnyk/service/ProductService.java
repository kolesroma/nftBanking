package com.kolesnyk.service;

import com.kolesnyk.dto.ProductCreationDto;
import com.kolesnyk.model.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

public interface ProductService {
    void saveProduct(ProductCreationDto productDto);

    Optional<Product> getById(int id);

    Collection<Product> getAllProducts(int page, int size);

    void updateProduct(ProductCreationDto productDto, int productId);

    void deleteProduct(int id);
}
