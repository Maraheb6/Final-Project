package com.example.springbootfinalproject.Controller;

import com.example.springbootfinalproject.DTO.CustomerDTO;
import com.example.springbootfinalproject.DTO.ServiceProviderDTO;
import com.example.springbootfinalproject.Service.MyUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/user")
public class MyUserController {

    private final MyUserService myUserService;

    // All
//    @PostMapping("/login")
//    public ResponseEntity login(){
//        return ResponseEntity.status(200).body("Logged in successfully");
//    }

    // Add(register) All
    @PostMapping("/customer/register")
    public ResponseEntity registerCustomer(@Valid @RequestBody CustomerDTO customerDTO){
        myUserService.addCustomer(customerDTO);
        return ResponseEntity.status(200).body("User(Customer) Created");
    }

    @PostMapping("/serviceProvider/register")
    public ResponseEntity registerServiceProvider(@Valid @RequestBody ServiceProviderDTO serviceProviderDTO){
        myUserService.addServiceProvider(serviceProviderDTO);
        return ResponseEntity.status(200).body("User(ServiceProvider) Created");
    }

    // update

//    @PutMapping("/update")
//    public ResponseEntity updateUser(@RequestBody @Valid MyUser newUser, @AuthenticationPrincipal MyUser auth){
//        myUserService.updateUser(newUser , auth.getId());
//        return ResponseEntity.status(200).body(new ApiResponse("User Updated"));
//    }


}
