package com.switchfully.parkshark_2024_10.division.dto;

import com.switchfully.parkshark_2024_10.director.dto.DirectorDto;




public class DivisionDto {
    private Long id;
    private String name;
    private DirectorDto directorDto;
    private String originalCompanyName;

    public DivisionDto(Long id, String name, DirectorDto directorDto, String originalCompanyName) {
        this.id = id;
        this.name = name;
        this.directorDto = directorDto;
        this.originalCompanyName = originalCompanyName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DirectorDto getDirectorDto() {
        return directorDto;
    }

    public String getOriginalCompanyName() {
        return originalCompanyName;
    }
}
