package com.example.finalproject.Service;

import com.example.finalproject.ApiException.ApiException;
import com.example.finalproject.Model.Address;
import com.example.finalproject.Model.Services;
import com.example.finalproject.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;

    //get all Address
    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }
    //get Address by id
    public Address getAddressById(Integer id){
       Address address=addressRepository.findAddressById(id);
        if (address==null){
            throw new ApiException("Address Not Found!");
        }
        return address;
    }
    //add Address
    public void addAddress(Address address){
        addressRepository.save(address);
    }

    //update Address
    public void updateAddress( Address address,Integer id){
        Address oldAddress=addressRepository.findAddressById(id);
        if(oldAddress==null){
            throw new ApiException("Address Not Found");
        }
        oldAddress.setId(id);
        oldAddress.setStreet(address.getStreet());
        oldAddress.setCity(address.getCity());
        oldAddress.setNeighborhood(address.getNeighborhood());
        oldAddress.setPostCode(address.getPostCode());
        oldAddress.setCountry(address.getCountry());

        addressRepository.save(oldAddress);
    }
    //delete Address

    public void deleteAddress(Integer id){
       Address address=addressRepository.findAddressById(id);
        if(address==null){
            throw new ApiException("Address Not Found");
        }
        addressRepository.delete(address);
    }
}
