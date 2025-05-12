package com.amazon.marketplace.AmazonMarketplace.mappers;

import com.amazon.marketplace.AmazonMarketplace.dtos.UserDto;
import com.amazon.marketplace.AmazonMarketplace.dtos.UserDto2;
import com.amazon.marketplace.AmazonMarketplace.entities.User;
import com.amazon.marketplace.AmazonMarketplace.entities.User2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper2 {

    private final AddressMapper2 addressMapper;

    public User2 mapToUser(UserDto2 userDto) {
        User2 user = new User2();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        // Convert string role to enum
        if (userDto.getRole() != null) {
            user.setRole(User2.Role.valueOf(userDto.getRole().toUpperCase()));
        }

        user.setProfilePictureUrl(userDto.getProfilePictureUrl());
        user.setCreatedAt(userDto.getCreatedAt());
        user.setUpdatedAt(userDto.getUpdatedAt());

        return user;
    }

    public UserDto2 mapToUserDto(User2 user) {
        UserDto2 userDto = new UserDto2();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());

        // Convert enum role to string
        if (user.getRole() != null) {
            userDto.setRole(user.getRole().name());
        }

        userDto.setProfilePictureUrl(user.getProfilePictureUrl());
        userDto.setCreatedAt(user.getCreatedAt());
        userDto.setUpdatedAt(user.getUpdatedAt());

        userDto.setAddressDto(addressMapper.mapToAddressDto(user.getAddress()));
        return userDto;
    }
}