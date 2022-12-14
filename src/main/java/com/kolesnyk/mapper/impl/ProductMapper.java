package com.kolesnyk.mapper.impl;

import com.kolesnyk.dto.creation.ProductCreationDto;
import com.kolesnyk.dto.ProductDto;
import com.kolesnyk.mapper.CreationDtoMapper;
import com.kolesnyk.mapper.DtoMapper;
import com.kolesnyk.model.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements DtoMapper<ProductEntity, ProductDto>, CreationDtoMapper<ProductEntity, ProductCreationDto> {
    @Override
    public ProductEntity toEntity(ProductCreationDto productDto) {
        return ProductEntity.builder()
                .id(0)
                .description(productDto.getDescription())
                .shortName(productDto.getShortName())
                .price(productDto.getPrice())
                .fullName(productDto.getFullName())
                .upc(productDto.getUpc())
                .build();
    }

    @Override
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
