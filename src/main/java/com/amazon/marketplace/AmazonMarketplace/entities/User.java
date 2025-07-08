package com.amazon.marketplace.AmazonMarketplace.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Entity
public class User {
    public enum Role {BUYER, SELLER, ADMIN}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name", nullable = false, length = 50)
    private String firstName;
    @Column(name="last_name", nullable = false, length = 50)
    private String lastName;
    @Column(name="email", nullable = false, unique = true, length = 100)
    private String email;
    @Column(name="username", nullable = false, unique = true, length = 30)
    private String username;
    @Column(name="password", nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role", length = 10)
    private Role role = Role.BUYER;

    @Column(name="profile_picture_url", length = 255)
    private String profilePictureUrl;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

//    We don't want orphanRemoval = true here because In most production e-commerce apps,
//    orders are retained for auditing, refunds, legal compliance, etc.
    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

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