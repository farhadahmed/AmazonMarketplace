package com.amazon.marketplace.AmazonMarketplace.repositories;

import com.amazon.marketplace.AmazonMarketplace.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
