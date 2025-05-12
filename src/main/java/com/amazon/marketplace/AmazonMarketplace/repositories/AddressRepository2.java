package com.amazon.marketplace.AmazonMarketplace.repositories;

import com.amazon.marketplace.AmazonMarketplace.entities.Address;
import com.amazon.marketplace.AmazonMarketplace.entities.Address2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AddressRepository2 extends JpaRepository<Address2, Integer> {
}
