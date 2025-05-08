package com.amazon.marketplace.AmazonMarketplace.services.impl;

import com.amazon.marketplace.AmazonMarketplace.dtos.AddressDto;
import com.amazon.marketplace.AmazonMarketplace.entities.Address;
import com.amazon.marketplace.AmazonMarketplace.mappers.AddressMapper;
import com.amazon.marketplace.AmazonMarketplace.repositories.AddressRepository;
import com.amazon.marketplace.AmazonMarketplace.repositories.UserRepository;
import com.amazon.marketplace.AmazonMarketplace.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public AddressDto createAddress(AddressDto addressDto, int userId) {
        Address address = addressMapper.mapToAddress(addressDto);
        Address savedAddress = addressRepository.save(address);
        return null;
    }

    @Override
    public AddressDto getAddressById(int id) {
        Address address = addressRepository.findById(id).
                orElseThrow( () -> new RuntimeException("Address of this ID does not exist") );
        return addressMapper.mapToAddressDto(address);
    }

    @Override
    public AddressDto getAddressByUserId(int userId) {
        if (userRepository.existsById(userId)) {
            Address address = addressRepository.getByUserId(userId);
            return addressMapper.mapToAddressDto(address);
        }
        return null;
    }

    @Override
    public List<AddressDto> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream().map(addressMapper::mapToAddressDto).
                collect(Collectors.toList());
    }

    @Override
    public AddressDto updateAddressById(int id, AddressDto addressDto) {
        Address address = addressRepository.findById(id).
                orElseThrow( () -> new RuntimeException("Address of this ID doesn't exist") );

        address.setStreet(addressDto.getStreet());
        address.setCity(addressDto.getCity());
        address.setState(addressDto.getState());
        address.setPostalCode(addressDto.getPostalCode());
        address.setCountry(addressDto.getCountry());

        Address savedAddress = addressRepository.save(address);
        return addressMapper.mapToAddressDto(savedAddress);
    }

    @Override
    public AddressDto updateAddressByUserId(int userId, AddressDto addressDto) {
        if (userRepository.existsById(userId)) {
            Address address = addressRepository.getByUserId(userId);

            address.setStreet(addressDto.getStreet());
            address.setCity(addressDto.getCity());
            address.setState(addressDto.getState());
            address.setPostalCode(addressDto.getPostalCode());
            address.setCountry(addressDto.getCountry());

            return addressMapper.mapToAddressDto(address);
        }
        return null;
    }

    @Override
    public String deleteAddressById(int id) {
        if (addressRepository.existsById(id)) {
            addressRepository.deleteById(id);
            return "Successfully deleted address " + id;
        }
        else {
            return "No record of that ID found.";
        }
    }
}
