package com.amazon.marketplace.AmazonMarketplace.mappers;

import com.amazon.marketplace.AmazonMarketplace.dtos.UserDto;
import com.amazon.marketplace.AmazonMarketplace.entities.Address;
import com.amazon.marketplace.AmazonMarketplace.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final AddressMapper addressMapper;

    public User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        // Convert string role to enum
        if (userDto.getRole() != null) {
            user.setRole(User.Role.valueOf(userDto.getRole().toUpperCase()));
        }

        user.setProfilePictureUrl(userDto.getProfilePictureUrl());

        // If addressDto is present, map and link it
        if (userDto.getAddressDto() != null) {
            Address address = addressMapper.mapToAddress(userDto.getAddressDto(), user);
            user.setAddress(address);
        }

        // We no longer set timestamps here — handled by @PrePersist/@PreUpdate
        return user;
    }

    public UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
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

        if (user.getAddress() != null) {
            userDto.setAddressDto(addressMapper.mapToAddressDto(user.getAddress()));
        }

        return userDto;
    }
}