package com.amazon.marketplace.AmazonMarketplace.mappers;

import com.amazon.marketplace.AmazonMarketplace.dtos.OrderDto;
import com.amazon.marketplace.AmazonMarketplace.entities.Order;
import com.amazon.marketplace.AmazonMarketplace.entities.User;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order mapToOrder(OrderDto orderDto, User buyer) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setBuyer(buyer);
        order.setTotalPrice(orderDto.getTotalPrice());

        if (orderDto.getStatus() != null) {
            order.setStatus(Order.Status.valueOf(orderDto.getStatus().toUpperCase()));
        }

        return order;
    }

    public OrderDto mapToOrderDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(order.getId());
        orderDto.setBuyerId(order.getBuyer().getId());
        orderDto.setTotalPrice(order.getTotalPrice());

        if (order.getStatus() != null) {
            orderDto.setStatus(order.getStatus().name());
        }

        orderDto.setCreatedAt(order.getCreatedAt());
        orderDto.setUpdatedAt(order.getUpdatedAt());

        return orderDto;
    }
}
