package com.amazon.marketplace.AmazonMarketplace.mappers;

import com.amazon.marketplace.AmazonMarketplace.dtos.AddressDto;
import com.amazon.marketplace.AmazonMarketplace.entities.Address;
import com.amazon.marketplace.AmazonMarketplace.entities.User;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address mapToAddress(AddressDto addressDto, User user) {
        Address address = new Address();

//        address.setId(addressDto.getId());
        address.setUser(user);
//        address.setUserId(addressDto.getUserId());
        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setPostalCode(addressDto.getPostalCode());
        address.setCountry(addressDto.getCountry());
        address.setCreatedAt(addressDto.getCreatedAt());
        address.setUpdatedAt(addressDto.getUpdatedAt());

        return address;
    }

    public AddressDto mapToAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();

        addressDto.setId(address.getId());
//        addressDto.setUserId(address.getUserId());
        addressDto.setUserId(address.getUser().getId());
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
