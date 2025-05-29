//package com.amazon.marketplace.AmazonMarketplace.deprecated;
//
//import com.amazon.marketplace.AmazonMarketplace.dtos.AddressDto;
//import com.amazon.marketplace.AmazonMarketplace.repositories.AddressRepositoryOld;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//public class AddressServiceImplOld implements AddressServiceOld {
//    @Autowired
//    private AddressRepositoryOld addressRepository;
//    @Autowired
//    private AddressMapperOld addressMapper;
//    @Autowired
//    private UserRepositoryOld userRepository;
//
//    @Override
//    public AddressDto createAddress(AddressDto addressDto) {
//        if (userRepository.existsById(addressDto.getUserId())) {
//            AddressOld address = addressMapper.mapToAddress(addressDto);
//            AddressOld savedAddress = addressRepository.save(address);
//            return addressMapper.mapToAddressDto(savedAddress);
//        }
//
//        throw new RuntimeException("User not found with ID: " + addressDto.getUserId());
//    }
//
////    public AddressDto createAddress2(AddressDto addressDto, int userId) {
////        // Step 1: Find the User
////        User user = userRepository.findById(userId)
////                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
////
////        // Step 2: Map DTO to Address and assign the User
////        Address address = addressMapper.mapToAddress(addressDto);
////        address.setUser(user);           // Required for @MapsId
////        address.setId(user.getId());     // Optional but reinforces the link
////        address.setCreatedAt(addressDto.getCreatedAt());
////        address.setUpdatedAt(addressDto.getUpdatedAt());
////
////        // Step 3: Save and map back to DTO
////        Address savedAddress = addressRepository.save(address);
////        return addressMapper.mapToAddressDto(savedAddress);
////    }
//
//
//    @Override
//    public AddressDto getAddressById(int id) {
//        AddressOld address = addressRepository.findById(id).
//                orElseThrow( () -> new RuntimeException("Address of this ID does not exist") );
//        return addressMapper.mapToAddressDto(address);
//    }
//
//    @Override
//    public AddressDto getAddressByUserId(int userId) {
//        if (userRepository.existsById(userId)) {
//            AddressOld address = addressRepository.getByUserId(userId);
//            return addressMapper.mapToAddressDto(address);
//        }
//        return null;
//    }
//
//    @Override
//    public List<AddressDto> getAllAddresses() {
//        List<AddressOld> addresses = addressRepository.findAll();
//        return addresses.stream().map(addressMapper::mapToAddressDto).
//                collect(Collectors.toList());
//    }
//
//    @Override
//    public AddressDto updateAddressById(int id, AddressDto addressDto) {
//        AddressOld address = addressRepository.findById(id).
//                orElseThrow( () -> new RuntimeException("Address of this ID doesn't exist") );
//
//        address.setStreet(addressDto.getStreet());
//        address.setCity(addressDto.getCity());
//        address.setState(addressDto.getState());
//        address.setPostalCode(addressDto.getPostalCode());
//        address.setCountry(addressDto.getCountry());
//
//        AddressOld savedAddress = addressRepository.save(address);
//        return addressMapper.mapToAddressDto(savedAddress);
//    }
//
//    @Override
//    public AddressDto updateAddressByUserId(int userId, AddressDto addressDto) {
//        if (userRepository.existsById(userId)) {
//            AddressOld address = addressRepository.getByUserId(userId);
//
//            address.setStreet(addressDto.getStreet());
//            address.setCity(addressDto.getCity());
//            address.setState(addressDto.getState());
//            address.setPostalCode(addressDto.getPostalCode());
//            address.setCountry(addressDto.getCountry());
//
//            return addressMapper.mapToAddressDto(address);
//        }
//        return null;
//    }
//
//    @Override
//    public String deleteAddressById(int id) {
//        if (addressRepository.existsById(id)) {
//            addressRepository.deleteById(id);
//            return "Successfully deleted address " + id;
//        }
//        else {
//            return "No record of that ID found.";
//        }
//    }
//}
