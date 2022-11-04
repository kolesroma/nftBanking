package com.kolesnyk.dto.mapper;

import com.kolesnyk.dto.ProductCreationDto;
import com.kolesnyk.dto.ProductDto;
import com.kolesnyk.model.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductEntity toProduct(ProductCreationDto productDto) {
        return ProductEntity.builder()
                .id(0)
                .description(productDto.getDescription())
                .shortName(productDto.getShortName())
                .price(productDto.getPrice())
                .fullName(productDto.getFullName())
                .upc(productDto.getUpc())
                .build();
    }

    public ProductDto toDto(ProductEntity product) {
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
