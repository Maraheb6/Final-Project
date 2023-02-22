package com.example.finalproject.Controller;

import com.example.finalproject.ApiResponse.ApiResponse;
import com.example.finalproject.Model.Address;
import com.example.finalproject.Model.Services;
import com.example.finalproject.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    // get all Addresses
    @GetMapping("/get-all")
    public ResponseEntity getAllAddresses(){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAllAddresses());
    }

    //get Address by id
    @GetMapping("get-by-id/{id}")
    public ResponseEntity getAddressById(@PathVariable Integer id ){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddressById(id));
    }

    //add  Address
    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid Address address){
        addressService.addAddress(address);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Address Added"));
    }
    //update Address
    @PutMapping("/update/{id}")
    public ResponseEntity updateAddress(@RequestBody @Valid Address address, @PathVariable Integer id){
       addressService.updateAddress(address,id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Address Updated"));
    }

    //delete Address
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Address deleted"));
    }

}
