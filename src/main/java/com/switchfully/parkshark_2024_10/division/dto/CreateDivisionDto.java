package com.switchfully.parkshark_2024_10.division.dto;

import com.switchfully.parkshark_2024_10.user.Director;
import jakarta.validation.constraints.NotNull;

public class CreateDivisionDto {
    String name;
    Director director;
    String originalCompanyName;

    public CreateDivisionDto(@NotNull String name,@NotNull Director director, String originalCompanyName) {
        this.name = name;
        this.director = director;
        this.originalCompanyName = originalCompanyName;
    }

    public String getName() {
        return name;
    }

    public Director getDirector() {
        return director;
    }

    public String getOriginalCompanyName() {
        return originalCompanyName;
    }
}
