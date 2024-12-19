package com.switchfully.parkshark_2024_10.division.dto;

import com.switchfully.parkshark_2024_10.user.Director;

public class DivisionDto {
    private Long id;
    private String name;
    private Director director;
    private String originalCompanyName;

    public DivisionDto(Long id, String name, Director director, String originalCompanyName) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.originalCompanyName = originalCompanyName;
    }

    public Long getId() {
        return id;
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
