package com.switchfully.parkshark_2024_10.director.dto;

import com.switchfully.parkshark_2024_10.division.dto.DivisionDto;


public class CreateDirectorDto {
    String firstName;
    String lastName;
    String email;
    String password;
    DivisionDto division;

    public CreateDirectorDto(String firstName, String lastName, String email, String password, DivisionDto division) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.division = division;
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

    public DivisionDto getDivision() {
        return division;
    }
}