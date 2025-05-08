package com.amazon.marketplace.AmazonMarketplace.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private int id;
    private int userId;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();
}
