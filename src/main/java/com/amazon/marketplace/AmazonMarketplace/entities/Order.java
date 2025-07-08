package com.amazon.marketplace.AmazonMarketplace.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
@Entity
public class Order {
    public enum Status {PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELLED, RETURN_REQUESTED, RETURNED, FAILED}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private User buyer;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice = BigDecimal.ZERO;

    @Enumerated(EnumType.STRING)
    @Column(name="status", length = 20)
    private Order.Status status = Status.PENDING;

    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt =  LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
