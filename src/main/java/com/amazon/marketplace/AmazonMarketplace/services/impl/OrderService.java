package com.amazon.marketplace.AmazonMarketplace.services.impl;

import com.amazon.marketplace.AmazonMarketplace.dtos.OrderDto;
import com.amazon.marketplace.AmazonMarketplace.entities.Order;
import com.amazon.marketplace.AmazonMarketplace.entities.User;
import com.amazon.marketplace.AmazonMarketplace.mappers.OrderMapper;
import com.amazon.marketplace.AmazonMarketplace.repositories.OrderRepository;
import com.amazon.marketplace.AmazonMarketplace.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;

    public OrderDto createOrder(OrderDto orderDto) {
        User buyer = userRepository.findById(orderDto.getBuyerId())
                .orElseThrow(() -> new RuntimeException("Buyer not found"));

        Order order = orderMapper.mapToOrder(orderDto, buyer);
        Order saved = orderRepository.save(order);

        return orderMapper.mapToOrderDto(saved);
    }

    public OrderDto getOrderById(int id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        return orderMapper.mapToOrderDto(order);
    }

    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(orderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    public List<OrderDto> getOrdersByBuyerId(int buyerId) {
        User buyer = userRepository.findById(buyerId)
                .orElseThrow(() -> new RuntimeException("Buyer not found"));

        return buyer.getOrders().stream()
                .map(orderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }
}
