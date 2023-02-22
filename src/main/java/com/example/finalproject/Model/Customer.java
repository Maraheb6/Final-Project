package com.example.springbootfinalproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @NotNull(message = "Name Should not be Empty")
    private String name;

    @NotNull(message = "email Should not be Empty")
    @Email
    private String email;

    @NotNull(message = "phone Number Should not be Empty")
    private String phoneNumber;

}
