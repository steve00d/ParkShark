package com.switchfully.parkshark_2024_10.division.dto;

import com.switchfully.parkshark_2024_10.user.Director;
import jakarta.validation.constraints.NotNull;

public class CreateDivisionDto {
    String name;
    CreateDirectorDto createDirectorDto;
    String originalCompanyName;

    public CreateDivisionDto(@NotNull String name,@NotNull CreateDirectorDto createDirectorDto, String originalCompanyName) {
        this.name = name;
        this.createDirectorDto = createDirectorDto;
        this.originalCompanyName = originalCompanyName;
    }

    public String getName() {
        return name;
    }

    public CreateDirectorDto getCreateDirectorDto() {
        return createDirectorDto;
    }

    public String getOriginalCompanyName() {
        return originalCompanyName;
    }
}
