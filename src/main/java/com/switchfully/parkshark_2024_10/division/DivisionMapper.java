package com.switchfully.parkshark_2024_10.division;

import com.switchfully.parkshark_2024_10.division.dto.CreateDivisionDto;
import com.switchfully.parkshark_2024_10.division.dto.DivisionDto;

public class DivisionMapper {

    public Division mapToDivision(CreateDivisionDto createDivisionDto) {
        return new Division(createDivisionDto.getName(), createDivisionDto.getDirector(), createDivisionDto.getOriginalCompanyName());
    }

    public DivisionDto mapToDivisionDto(Division division) {
        return new DivisionDto(
                division.getId(),
                division.getName(),
                division.getDirector(),
                division.getOriginalCompanyName());
    }
}
