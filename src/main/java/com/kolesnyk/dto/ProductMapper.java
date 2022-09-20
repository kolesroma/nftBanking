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
}
