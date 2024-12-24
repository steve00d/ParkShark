package com.switchfully.parkshark_2024_10.division.dto;

import com.switchfully.parkshark_2024_10.director.dto.CreateDirectorDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateDivisionDto {
    @NotBlank
    String name;

    @NotNull
    @Valid
    CreateDirectorDto director;

    String originalCompanyName;

    public CreateDivisionDto(String name, CreateDirectorDto director, String originalCompanyName) {
        this.name = name;
        this.director = director;
        this.originalCompanyName = originalCompanyName;
    }

    public String getName() {
        return name;
    }

    public CreateDirectorDto getCreateDirectorDto() {
        return director;
    }

    public String getOriginalCompanyName() {
        return originalCompanyName;
    }
}
