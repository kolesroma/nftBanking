package com.kolesnyk.service.impl;

import com.kolesnyk.dto.creation.ProductCreationDto;
import com.kolesnyk.dto.ProductDto;
import com.kolesnyk.mapper.impl.ProductMapper;
import com.kolesnyk.exception.ProductNotFound;
import com.kolesnyk.model.ProductEntity;
import com.kolesnyk.repository.ProductRepository;
import com.kolesnyk.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    @Override
    public void saveProduct(ProductCreationDto productDto) {
        productRepository.save(mapper.toEntity(productDto));
    }

    @Override
    public ProductDto getById(int id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFound("there is no product with id " + id));
        return mapper.toDto(product);
    }

    @Override
    public Collection<ProductDto> getAllProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size))
                .map(mapper::toDto)
                .getContent();
    }

    @Override
    @Transactional
    public void updateProduct(ProductCreationDto productDto, int productId) {
        if (!productRepository.existsById(productId)) {
            throw new ProductNotFound("there is no product with id " + productId);
        }
        ProductEntity product = mapper.toEntity(productDto);
        product.setId(productId);
        productRepository.save(product);
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFound("there is no product with id " + id);
        }
        productRepository.deleteById(id);
    }
}
