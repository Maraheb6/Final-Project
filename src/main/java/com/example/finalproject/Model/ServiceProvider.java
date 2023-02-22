package com.example.springbootfinalproject.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceProvider {

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

    @NotNull(message = "Specialised At Should not be Empty")
    private String SpecialisedAt;

    @NotNull(message = "years Of Experience Should not be Empty")
    private Integer yearsOfExperience;

    @NotNull(message = "Commercial Register Should not be Empty")
    private String CommercialRegister;


}
