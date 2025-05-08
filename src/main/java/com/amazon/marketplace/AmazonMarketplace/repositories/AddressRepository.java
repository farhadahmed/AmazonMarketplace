package com.amazon.marketplace.AmazonMarketplace.repositories;

import com.amazon.marketplace.AmazonMarketplace.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    @Query(value = "SELECT * FROM addresses WHERE user_id = ?", nativeQuery = true)
    Address getByUserId(int userId);
}
