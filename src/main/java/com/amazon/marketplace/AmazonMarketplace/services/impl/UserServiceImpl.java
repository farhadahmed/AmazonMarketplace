package com.amazon.marketplace.AmazonMarketplace.services.impl;

import com.amazon.marketplace.AmazonMarketplace.dtos.UserDto;
import com.amazon.marketplace.AmazonMarketplace.entities.Address;
import com.amazon.marketplace.AmazonMarketplace.entities.User;
import com.amazon.marketplace.AmazonMarketplace.mappers.AddressMapper;
import com.amazon.marketplace.AmazonMarketplace.mappers.UserMapper;
import com.amazon.marketplace.AmazonMarketplace.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;


    public UserDto createUser(UserDto userDto) {
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

        User user = userMapper.mapToUser(userDto);
        Address address = addressMapper.mapToAddress(userDto.getAddressDto(), user);
        user.setAddress(address);
        User savedUser = userRepository.save(user);
        return userMapper.mapToUserDto(savedUser);
    }


    public UserDto getUserById(int id) {
        User user = userRepository.
                findById(id).
                orElseThrow( () -> new RuntimeException("User of this ID does not exist") );

        return userMapper.mapToUserDto(user);
    }


    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::mapToUserDto)
                .collect(Collectors.toList());
    }


    public UserDto updateUserById(int id, UserDto userDto) {
        /*
            1. Retrieve product by id
            2. Use setters to change the properties of user
            3. Save the user in the DB with the updated properties.
            4. Convert the entity user into a DTO object
            5. Return the DTO object to the Controller
         */

        // Step 1.
        User user = userRepository.
                findById(id).
                orElseThrow( () -> new RuntimeException("User of this ID does not exist") );

        // Step 2.
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());

        if (userDto.getAddressDto() != null) {
            Address updatedAddress = addressMapper.mapToAddress(userDto.getAddressDto(), user);
            user.setAddress(updatedAddress);
        }

        // Step 3.
        User savedUser = userRepository.save(user);

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
