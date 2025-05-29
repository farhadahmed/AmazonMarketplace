package com.amazon.marketplace.AmazonMarketplace.mappers;

import com.amazon.marketplace.AmazonMarketplace.dtos.ProductDto;
import com.amazon.marketplace.AmazonMarketplace.entities.Product;
import com.amazon.marketplace.AmazonMarketplace.entities.User;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product mapToProduct(ProductDto productDto, User seller) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setQuantityAvailable(productDto.getQuantityAvailable());
        product.setSeller(seller);
        product.setImageUrl(productDto.getImageUrl());
        product.setCategory(productDto.getCategory());
        product.setCreatedAt(productDto.getCreatedAt());
        product.setUpdatedAt(productDto.getUpdatedAt());
        return product;
    }

    public ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setQuantityAvailable(product.getQuantityAvailable());
        productDto.setSellerId(product.getSeller().getId());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setCategory(product.getCategory());
        productDto.setCreatedAt(productDto.getCreatedAt());
        productDto.setUpdatedAt(productDto.getUpdatedAt());
        return productDto;
    }
}
