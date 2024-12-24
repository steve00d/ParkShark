package com.switchfully.parkshark_2024_10.division;

import com.switchfully.parkshark_2024_10.director.DirectorMapper;
import com.switchfully.parkshark_2024_10.director.dto.CreateDirectorDto;
import com.switchfully.parkshark_2024_10.division.dto.CreateDivisionDto;
import com.switchfully.parkshark_2024_10.division.dto.DivisionDto;
import com.switchfully.parkshark_2024_10.user.Director;

public class DivisionMapper {

    public static Division mapToDivision(CreateDivisionDto createDivisionDto) {
        CreateDirectorDto createDirectorDto = createDivisionDto.getCreateDirectorDto();
        Director director = DirectorMapper.mapToDirector(createDirectorDto);
        return new Division(createDivisionDto.getName(),
                director,
                createDivisionDto.getOriginalCompanyName());
    }

    public static DivisionDto mapToDivisionDto(Division division) {
        return new DivisionDto(
                division.getId(),
                division.getName(),
                DirectorMapper.mapToDirectorDto(division.getDirector()),
                division.getOriginalCompanyName()
        );
    }
}
