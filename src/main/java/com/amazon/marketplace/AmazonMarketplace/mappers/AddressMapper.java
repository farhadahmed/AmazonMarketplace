package com.amazon.marketplace.AmazonMarketplace.mappers;

import com.amazon.marketplace.AmazonMarketplace.dtos.AddressDto;
import com.amazon.marketplace.AmazonMarketplace.entities.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address mapToAddress(AddressDto addressDto) {
        Address address = new Address();

        address.setId(addressDto.getId());
//        address.setUserId(addressDto.getUserId());
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setPostalCode(address.getPostalCode());
        address.setCountry(addressDto.getCountry());
        address.setCreatedAt(addressDto.getCreatedAt());
        address.setUpdatedAt(addressDto.getUpdatedAt());

        return address;
    }

    public AddressDto mapToAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();

        addressDto.setId(address.getId());
//        addressDto.setUserId(address.getUserId());
        addressDto.setStreet(address.getStreet());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setPostalCode(address.getPostalCode());
        addressDto.setCountry(address.getCountry());
        addressDto.setCreatedAt(address.getCreatedAt());
        addressDto.setUpdatedAt(address.getUpdatedAt());

        return addressDto;
    }
}
