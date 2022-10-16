package com.kolesnyk.service;

import com.kolesnyk.dto.ProductCreationDto;
import com.kolesnyk.dto.ProductDto;

import java.util.Collection;

public interface ProductService {
    void saveProduct(ProductCreationDto productDto);

    ProductDto getById(int id);

    Collection<ProductDto> getAllProducts(int page, int size);

    void updateProduct(ProductCreationDto productDto, int productId);

    void deleteProduct(int id);
}
