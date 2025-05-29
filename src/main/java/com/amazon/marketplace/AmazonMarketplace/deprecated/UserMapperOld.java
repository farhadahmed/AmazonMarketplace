//package com.amazon.marketplace.AmazonMarketplace.deprecated;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class UserMapperOld {
//
////    private final AddressMapper addressMapper;
//
//    public UserOld mapToUser(UserDtoOld userDto) {
//        UserOld user = new UserOld();
//        user.setId(userDto.getId());
//        user.setFirstName(userDto.getFirstName());
//        user.setLastName(userDto.getLastName());
//        user.setEmail(userDto.getEmail());
//        user.setUsername(userDto.getUsername());
//        user.setPassword(userDto.getPassword());
//
//        // Convert string role to enum
//        if (userDto.getRole() != null) {
//            user.setRole(UserOld.Role.valueOf(userDto.getRole().toUpperCase()));
//        }
//
//        user.setProfilePictureUrl(userDto.getProfilePictureUrl());
//        user.setCreatedAt(userDto.getCreatedAt());
//        user.setUpdatedAt(userDto.getUpdatedAt());
//
//        return user;
//    }
//
//    public UserDtoOld mapToUserDto(UserOld user) {
//        UserDtoOld userDto = new UserDtoOld();
//        userDto.setId(user.getId());
//        userDto.setFirstName(user.getFirstName());
//        userDto.setLastName(user.getLastName());
//        userDto.setEmail(user.getEmail());
//        userDto.setUsername(user.getUsername());
//        userDto.setPassword(user.getPassword());
//
//        // Convert enum role to string
//        if (user.getRole() != null) {
//            userDto.setRole(user.getRole().name());
//        }
//
//        userDto.setProfilePictureUrl(user.getProfilePictureUrl());
//        userDto.setCreatedAt(user.getCreatedAt());
//        userDto.setUpdatedAt(user.getUpdatedAt());
//
////        userDto.setAddressDto(addressMapper.mapToAddressDto(user.getAddress()));
//        return userDto;
//    }
//}