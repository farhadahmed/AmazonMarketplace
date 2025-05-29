package com.amazon.marketplace.AmazonMarketplace.repositories;

import com.amazon.marketplace.AmazonMarketplace.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findBySellerId(int sellerId);
}
