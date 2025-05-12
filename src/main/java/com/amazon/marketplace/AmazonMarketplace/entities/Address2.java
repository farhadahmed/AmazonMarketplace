package com.amazon.marketplace.AmazonMarketplace.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="addresses2")
@Entity
public class Address2 {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @Column(name="user_id", nullable = false)
//    private int userId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User2 user;

    @Column(name="street", nullable = false)
    private String street;
    @Column(name="city", nullable = false, length = 100)
    private String city;
    @Column(name="state", nullable = false, length = 100)
    private String state;
    @Column(name="postal_code", nullable = false, length = 20)
    private String postalCode;
    @Column(name="country", nullable = false, length = 100)
    private String country;
    @Column(name="created_at")
    private LocalDateTime createdAt;
    @Column(name="updated_at")
    private LocalDateTime updatedAt;
}