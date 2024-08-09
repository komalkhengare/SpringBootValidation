package com.example.SpringBootValidation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;

    // name should not be null or empty
    //  name should have at least 2 characters
    @NotEmpty
    @Size(min=2,message = "Name should have at least 2 characters")
    private String name;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Size(min=8,message = "password should have at least 8 characters")
    private String password;
}
