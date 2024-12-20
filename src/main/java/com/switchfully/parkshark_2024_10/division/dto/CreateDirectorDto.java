package com.switchfully.parkshark_2024_10.division.dto;

import com.switchfully.parkshark_2024_10.division.Division;

public class CreateDirectorDto {
    String firstName;
    String lastName;
    String email;
    String password;

    public CreateDirectorDto(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
