package com.amazon.marketplace.AmazonMarketplace.services.impl;

import com.amazon.marketplace.AmazonMarketplace.dtos.ProductDto;
import com.amazon.marketplace.AmazonMarketplace.entities.Product;
import com.amazon.marketplace.AmazonMarketplace.entities.User;
import com.amazon.marketplace.AmazonMarketplace.mappers.ProductMapper;
import com.amazon.marketplace.AmazonMarketplace.repositories.ProductRepository;
import com.amazon.marketplace.AmazonMarketplace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private UserRepository userRepository;

    public ProductDto createProduct(ProductDto productDto) {
        User seller = userRepository.findById(productDto.getSellerId())
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        if (seller.getRole() != User.Role.SELLER) {
            throw new RuntimeException("User is not a seller");
        }

        Product product = productMapper.mapToProduct(productDto, seller);
        Product saved = productRepository.save(product);
        return productMapper.mapToProductDto(saved);
    }

    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::mapToProductDto)
                .collect(Collectors.toList());
    }
}
