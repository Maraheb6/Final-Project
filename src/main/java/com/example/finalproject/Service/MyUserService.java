package com.example.springbootfinalproject.Service;

import com.example.springbootfinalproject.DTO.CustomerDTO;
import com.example.springbootfinalproject.DTO.ServiceProviderDTO;
import com.example.springbootfinalproject.Exception.ApiException;
import com.example.springbootfinalproject.Model.Customer;
import com.example.springbootfinalproject.Model.MyUser;
import com.example.springbootfinalproject.Model.ServiceProvider;
import com.example.springbootfinalproject.Repository.CustomerRepository;
import com.example.springbootfinalproject.Repository.MyUserRepository;
import com.example.springbootfinalproject.Repository.ServiceProviderRepository;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MyUserService {

    private final MyUserRepository myUserRepository;
    private final CustomerRepository customerRepository;

    private final ServiceProviderRepository serviceProviderRepository;


    // Get All users
    public List<MyUser> getAllUsers(){
        return myUserRepository.findAll();
    }

    // Add Customer & User
    public void addCustomer(CustomerDTO customerDTO){

        MyUser currentUser = myUserRepository.findMyUsersByUsername(customerDTO.getUsername());

        // check username
        if(currentUser==null) {

        // add user
        MyUser myUser = new MyUser();
        myUser.setRole(customerDTO.getRole());
        myUser.setPassword(customerDTO.getPassword());
//        String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
//        myUser.setPassword(hashedPassword);
        myUser.setUsername(customerDTO.getUsername());
        myUserRepository.save(myUser);

        // add customer
        Customer customer = new Customer(customerDTO.getId(),customerDTO.getName(),customerDTO.getEmail(),customerDTO.getPhoneNumber());
        customerRepository.save(customer); }
        else throw new ApiException("The User name is used by another user");

    }

    // Add Service Provider & User
    public void addServiceProvider(ServiceProviderDTO serviceProviderDTO){

        MyUser currentUser = myUserRepository.findMyUsersByUsername(serviceProviderDTO.getUsername());

        // check username
        if(currentUser==null) {

            //add user
            MyUser myUser = new MyUser();
            myUser.setRole(serviceProviderDTO.getRole());
            myUser.setPassword(serviceProviderDTO.getPassword());
//          String hashedPassword=new BCryptPasswordEncoder().encode(myUser.getPassword());
//          myUser.setPassword(hashedPassword);
            myUser.setUsername(serviceProviderDTO.getUsername());
            myUserRepository.save(myUser);


            // add service provider
            ServiceProvider serviceProvider = new ServiceProvider(serviceProviderDTO.getId(), serviceProviderDTO.getName(), serviceProviderDTO.getEmail(), serviceProviderDTO.getPhoneNumber(), serviceProviderDTO.getSpecialisedAt(), serviceProviderDTO.getYearsOfExperience(), serviceProviderDTO.getCommercialRegister());
            serviceProviderRepository.save(serviceProvider);

        }
        else throw new ApiException("The User name is used by another user");
    }


    // Delete User
    public void deleteUser(Integer id){
        MyUser myUser=myUserRepository.findMyUsersById(id);
        if(myUser==null){
            throw new ApiException("User Not Found");
        }
        myUserRepository.delete(myUser);
    }

    // Update User
    public void updateUser(MyUser newUser, Integer id){
        MyUser oldUser=myUserRepository.findMyUsersById(id);

        newUser.setId(id);
        newUser.setRole(oldUser.getRole());
//        newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));

        myUserRepository.save(newUser);
    }

}
