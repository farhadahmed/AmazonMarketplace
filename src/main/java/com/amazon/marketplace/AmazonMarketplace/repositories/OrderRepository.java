package com.amazon.marketplace.AmazonMarketplace.repositories;

import com.amazon.marketplace.AmazonMarketplace.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    // Get all orders by buyer ID
    List<Order> findByBuyerId(int buyerId);

    // Optionally, get all orders by status
    List<Order> findByStatus(Order.Status status);
}
