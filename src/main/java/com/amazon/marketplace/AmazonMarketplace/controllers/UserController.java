package com.amazon.marketplace.AmazonMarketplace.controllers;

import com.amazon.marketplace.AmazonMarketplace.dtos.UserDto;
import com.amazon.marketplace.AmazonMarketplace.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUserById(@PathVariable int id, @RequestBody UserDto userDto) {
        userDto.setUpdatedAt(LocalDateTime.now());
        UserDto updatedUserDto = userService.updateUserById(id, userDto);
        return ResponseEntity.ok(updatedUserDto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        String response = userService.deleteUserById(id);
        return ResponseEntity.ok(response);
    }
}
