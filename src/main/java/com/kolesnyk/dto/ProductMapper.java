package com.kolesnyk.dto;

import com.kolesnyk.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toProduct(ProductCreationDto productDto) {
        return Product.builder()
                .id(0)
                .description(productDto.getDescription())
                .shortName(productDto.getShortName())
                .price(productDto.getPrice())
                .fullName(productDto.getFullName())
                .upc(productDto.getUpc())
                .build();
    }

    public ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .description(product.getDescription())
                .shortName(product.getShortName())
                .price(product.getPrice())
                .fullName(product.getFullName())
                .upc(product.getUpc())
                .build();
    }
}
