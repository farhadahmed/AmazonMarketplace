package com.amazon.marketplace.AmazonMarketplace.services;

import com.amazon.marketplace.AmazonMarketplace.dtos.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto createAddress(AddressDto addressDto);
    AddressDto getAddressById(int id);
    AddressDto getAddressByUserId(int userId);
    List<AddressDto> getAllAddresses();
    AddressDto updateAddressById(int id, AddressDto addressDto);
    AddressDto updateAddressByUserId(int userId, AddressDto addressDto);
    String deleteAddressById(int id);
}