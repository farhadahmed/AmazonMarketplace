//package com.amazon.marketplace.AmazonMarketplace.controllers;
//
//import com.amazon.marketplace.AmazonMarketplace.dtos.AddressDto;
//import com.amazon.marketplace.AmazonMarketplace.services.AddressService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/addresses")
//public class AddressController {
//    @Autowired
//    private AddressService addressService;
//
//    @PostMapping
//    public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDto) {
//        return new ResponseEntity<>(addressService.createAddress(addressDto), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<AddressDto> getAddressById(@PathVariable int id) {
//        AddressDto addressDto = addressService.getAddressById(id);
//        return ResponseEntity.ok(addressDto);
//    }
//
//    @GetMapping("/user/{id}")
//    public ResponseEntity<AddressDto> getAddressByUserId(@PathVariable int id) {
//        AddressDto addressDto = addressService.getAddressByUserId(id);
//        return ResponseEntity.ok(addressDto);
//    }
//
//    @GetMapping
//    public ResponseEntity<List<AddressDto>> getAddressAllAddresses() {
//        List<AddressDto> addressDtos = addressService.getAllAddresses();
//        return ResponseEntity.ok(addressDtos);
//    }
//
//    @PutMapping("/user/{id}")
//    public ResponseEntity<AddressDto> updateAddressByUserId(@PathVariable int id, @RequestBody AddressDto addressDto) {
//        addressDto.setUpdatedAt(LocalDateTime.now());
//        AddressDto updatedAddressDto = addressService.updateAddressByUserId(id, addressDto);
//        return ResponseEntity.ok(updatedAddressDto);
//    }
//
//    @DeleteMapping("/user/{id}")
//    public ResponseEntity<String> deleteAddressById(@PathVariable int id){
//        String response = addressService.deleteAddressById(id);
//        return ResponseEntity.ok(response);
//    }
//}
