package com.amazon.marketplace.AmazonMarketplace.services.impl;

import com.amazon.marketplace.AmazonMarketplace.dtos.UserDto;
import com.amazon.marketplace.AmazonMarketplace.entities.User;
import com.amazon.marketplace.AmazonMarketplace.mappers.UserMapper;
import com.amazon.marketplace.AmazonMarketplace.repositories.UserRepository;
import com.amazon.marketplace.AmazonMarketplace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;


    @Override
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
        User savedUser = userRepository.save(user);
        return userMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(int id) {
        User user = userRepository.
                findById(id).
                orElseThrow( () -> new RuntimeException("User of this ID does not exist") );

        return userMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        /*
            1. Retrieve JPA users from the database and add them to a List
            2. Convert each object in the JPA list to a DTO object
            3. Return the list of DTO objects
         */

        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(userMapper::mapToUserDto)
                .collect(Collectors.toList());

        return userDtos;
    }

    @Override
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
        user.setPassword(userDto.getPassword());

        // Step 3.
        User savedUser = userRepository.save(user);

        // Step 4 and 5
        return userMapper.mapToUserDto(savedUser);
    }

    @Override
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
