//package com.amazon.marketplace.AmazonMarketplace.deprecated;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/users/old")
//public class UserControllerOld {
//
//    @Autowired
//    private UserServiceOld userService;
//
//    @PostMapping
//    public ResponseEntity<UserDtoOld> addUser(@RequestBody UserDtoOld userDto) {
//        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<UserDtoOld> getUserById(@PathVariable int id) {
//        UserDtoOld userDto = userService.getUserById(id);
//        return ResponseEntity.ok(userDto);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<UserDtoOld>> getAllUsers() {
//        List<UserDtoOld> userDtos = userService.getAllUsers();
//        return ResponseEntity.ok(userDtos);
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<UserDtoOld> updateUserById(@PathVariable int id, @RequestBody UserDtoOld userDto) {
//        userDto.setUpdatedAt(LocalDateTime.now());
//        UserDtoOld updatedUserDto = userService.updateUserById(id, userDto);
//        return ResponseEntity.ok(updatedUserDto);
//
//    }
//
//    @DeleteMapping("{id}")
//    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
//        String response = userService.deleteUserById(id);
//        return ResponseEntity.ok(response);
//    }
//}
