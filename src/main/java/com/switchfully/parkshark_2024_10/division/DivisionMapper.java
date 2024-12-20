package com.switchfully.parkshark_2024_10.division;

import com.switchfully.parkshark_2024_10.director.DirectorMapper;
import com.switchfully.parkshark_2024_10.director.dto.DirectorDto;
import com.switchfully.parkshark_2024_10.division.dto.CreateDivisionDto;
import com.switchfully.parkshark_2024_10.division.dto.DivisionDto;

public abstract class DivisionMapper {

    public static Division mapToDivision(CreateDivisionDto createDivisionDto) {
        return new Division(createDivisionDto.getName(), createDivisionDto.getCreateDirectorDto(), createDivisionDto.getOriginalCompanyName());
    }

    public static DivisionDto mapToDivisionDto(Division division) {
        DirectorDto directorDto = DirectorMapper.mapToDirectorDto(division.getDirector());
        return new DivisionDto(
                division.getId(),
                division.getName(),
                division.getDirector(),
                division.getOriginalCompanyName());
    }
}
