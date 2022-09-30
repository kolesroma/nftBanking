package com.kolesnyk.service;

import com.kolesnyk.dto.ProductCreationDto;
import com.kolesnyk.dto.ProductMapper;
import com.kolesnyk.exception.ProductNotFound;
import com.kolesnyk.model.Product;
import com.kolesnyk.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public void saveProduct(ProductCreationDto productDto) {
        productRepository.save(mapper.toProduct(productDto));
    }

    @Override
    public Optional<Product> getById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public Collection<Product> getAllProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size))
                .getContent();
    }

    @Override
    public void updateProduct(ProductCreationDto productDto, int productId) {
        if (!productRepository.existsById(productId))
            throw new ProductNotFound("there is no product with id " + productId);
        Product product = mapper.toProduct(productDto);
        product.setId(productId);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        if (!productRepository.existsById(id))
            throw new ProductNotFound("there is no product with id " + id);
        productRepository.deleteById(id);
    }
}
