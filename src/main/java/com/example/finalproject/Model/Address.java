package com.example.finalproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotNull(message = "Street Should not be Empty")
    @Size(min = 10,message = "Street Should not be less than 10")
    private String street;
    @NotNull(message = "City Should not be Empty")
    private String city;
    @NotNull(message = "neighborhood Should not be Empty")
    private  String neighborhood;
    @NotNull(message = "postCode Should not be Empty")
    @Size(min = 4,max = 5,message = "Postcode Should not be less than 10")
    private String postCode;
    @NotNull(message = "Country Should not be Empty")
    private  String country;


}
