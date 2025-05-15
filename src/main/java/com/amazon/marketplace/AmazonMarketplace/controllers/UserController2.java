package com.amazon.marketplace.AmazonMarketplace.controllers;

import com.amazon.marketplace.AmazonMarketplace.dtos.UserDto;
import com.amazon.marketplace.AmazonMarketplace.dtos.UserDto2;
import com.amazon.marketplace.AmazonMarketplace.services.UserService;
import com.amazon.marketplace.AmazonMarketplace.services.impl.UserServiceImpl2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users2")
public class UserController2 {

    @Autowired
    private UserServiceImpl2 userService;

    @PostMapping
    public ResponseEntity<UserDto2> addUser(@RequestBody UserDto2 userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto2> getUserById(@PathVariable int id) {
        UserDto2 userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto2>> getAllUsers() {
        List<UserDto2> userDtos = userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto2> updateUserById(@PathVariable int id, @RequestBody UserDto2 userDto) {
        userDto.setUpdatedAt(LocalDateTime.now());
        UserDto2 updatedUserDto = userService.updateUserById(id, userDto);
        return ResponseEntity.ok(updatedUserDto);

    }

//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
//        String response = userService.deleteUserById(id);
//        return ResponseEntity.ok(response);
//    }
}
