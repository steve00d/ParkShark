package com.switchfully.parkshark_2024_10.director.dto;

import com.switchfully.parkshark_2024_10.division.dto.DivisionDto;

import java.io.Serializable;


public class DirectorDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    String password;
    DivisionDto divisionDto;

    public DirectorDto(Long id, String firstName, String lastName, String email, String password, DivisionDto divisionDto) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.divisionDto = divisionDto;
    }

    public Long getId() {
        return id;
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

    public DivisionDto getDivisionDto() {
        return divisionDto;
    }
}