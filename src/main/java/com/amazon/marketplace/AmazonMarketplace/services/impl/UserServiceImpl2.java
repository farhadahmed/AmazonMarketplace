package com.amazon.marketplace.AmazonMarketplace.services.impl;

import com.amazon.marketplace.AmazonMarketplace.dtos.UserDto;
import com.amazon.marketplace.AmazonMarketplace.dtos.UserDto2;
import com.amazon.marketplace.AmazonMarketplace.entities.Address2;
import com.amazon.marketplace.AmazonMarketplace.entities.User;
import com.amazon.marketplace.AmazonMarketplace.entities.User2;
import com.amazon.marketplace.AmazonMarketplace.mappers.AddressMapper2;
import com.amazon.marketplace.AmazonMarketplace.mappers.UserMapper;
import com.amazon.marketplace.AmazonMarketplace.mappers.UserMapper2;
import com.amazon.marketplace.AmazonMarketplace.repositories.UserRepository;
import com.amazon.marketplace.AmazonMarketplace.repositories.UserRepository2;
import com.amazon.marketplace.AmazonMarketplace.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl2 {
    @Autowired
    private UserRepository2 userRepository;
    @Autowired
    private UserMapper2 userMapper;
    @Autowired
    private AddressMapper2 addressMapper;


    public UserDto2 createUser(UserDto2 userDto) {
        /*
            Service receives a Java object of the User
            1. Convert the DTO into an Entity/JPA object that can be
               stored in a database
            2. Communicate with the DB to store the new user entity
            3. When the DB responds with the user and new ID,
               convert the Entity object from the DB response into a
               DTO object.
            4. Return that DTO object to the controller
         */

        User2 user = userMapper.mapToUser(userDto);
        Address2 address = addressMapper.mapToAddress(userDto.getAddressDto(), user);
        user.setAddress(address);
        User2 savedUser = userRepository.save(user);
        return userMapper.mapToUserDto(savedUser);
    }


    public UserDto2 getUserById(int id) {
        User2 user = userRepository.
                findById(id).
                orElseThrow( () -> new RuntimeException("User of this ID does not exist") );

        return userMapper.mapToUserDto(user);
    }


    public List<UserDto2> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::mapToUserDto)
                .collect(Collectors.toList());
    }


    public UserDto2 updateUserById(int id, UserDto2 userDto) {
        /*
            1. Retrieve product by id
            2. Use setters to change the properties of user
            3. Save the user in the DB with the updated properties.
            4. Convert the entity user into a DTO object
            5. Return the DTO object to the Controller
         */

        // Step 1.
        User2 user = userRepository.
                findById(id).
                orElseThrow( () -> new RuntimeException("User of this ID does not exist") );

        // Step 2.
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        if (userDto.getAddressDto() != null) {
            Address2 updatedAddress = addressMapper.mapToAddress(userDto.getAddressDto(), user);
            user.setAddress(updatedAddress);
        }

        // Step 3.
        User2 savedUser = userRepository.save(user);

        // Step 4 and 5
        return userMapper.mapToUserDto(savedUser);
    }


    public String deleteUserById(int id) {
        /*
            1. Check if the object of this id exists
            2. If it does, delete it.
         */
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "Successfully deleted user " + id;
        }
        else {
            return "No record of that ID found.";
        }
    }
}
