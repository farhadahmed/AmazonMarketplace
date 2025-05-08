package com.amazon.marketplace.AmazonMarketplace.controllers;

import com.amazon.marketplace.AmazonMarketplace.dtos.AddressDto;
import com.amazon.marketplace.AmazonMarketplace.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDto) {
        return new ResponseEntity<>(addressService.createAddress(addressDto, 1), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable int id) {
        AddressDto addressDto = addressService.getAddressById(id);
        return ResponseEntity.ok(addressDto);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<AddressDto> getAddressByUserId(@PathVariable int id) {
        AddressDto addressDto = addressService.getAddressByUserId(id);
        return ResponseEntity.ok(addressDto);
    }


}
