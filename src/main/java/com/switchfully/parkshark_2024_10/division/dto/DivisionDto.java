package com.switchfully.parkshark_2024_10.division.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.parkshark_2024_10.director.dto.DirectorDto;

public class DivisionDto {
    private Long id;
    private String name;
    @JsonProperty("directorDto")
    private DirectorDto director;
    private String originalCompanyName;

    public DivisionDto(Long id, String name, DirectorDto director, String originalCompanyName) {
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

    public DirectorDto getDirectorDto() {
        return director;
    }

    public String getOriginalCompanyName() {
        return originalCompanyName;
    }
}
