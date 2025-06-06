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
public class ProductService {
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

    public List<ProductDto> getProductsBySellerId(int sellerId) {
        return productRepository.findBySellerId(sellerId)
                .stream()
                .map(productMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    public ProductDto updateProductById(int id, ProductDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Only allow the seller to update
        User seller = userRepository.findById(productDto.getSellerId())
                .orElseThrow(() -> new RuntimeException("Seller not found"));

        if (seller.getRole() != User.Role.SELLER) {
            throw new RuntimeException("User is not a seller");
        }

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantityAvailable(productDto.getQuantityAvailable());
        product.setImageUrl(productDto.getImageUrl());
        product.setCategory(productDto.getCategory());

        product.setSeller(seller); // Optional, if seller might change
        Product saved = productRepository.save(product);
        return productMapper.mapToProductDto(saved);
    }

    public String deleteProductById(int id) {
        if (!productRepository.existsById(id)) {
            return "Product not found";
        }
        productRepository.deleteById(id);
        return "Product deleted successfully";
    }
}
