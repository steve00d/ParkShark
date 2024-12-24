package com.switchfully.parkshark_2024_10.director;

import com.switchfully.parkshark_2024_10.director.dto.CreateDirectorDto;
import com.switchfully.parkshark_2024_10.director.dto.DirectorDto;
import com.switchfully.parkshark_2024_10.user.Director;

public abstract class DirectorMapper {

    public static DirectorDto mapToDirectorDTO(Director director){
        return null;
                //new DirectorDTO(director.getId(), director.getName(),....);
    }

    public static Director mapToDirector(CreateDirectorDto createDirectorDTO){
        return new Director(
                createDirectorDTO.getFirstName(),
                createDirectorDTO.getLastName(),
                createDirectorDTO.getEmail(),
                createDirectorDTO.getPassword(),
                null
        );

}

    public static DirectorDto mapToDirectorDto(Director director) {
        return new DirectorDto(
                director.getId(),
                director.getFirstName(),
                director.getLastName(),
                director.getEmail(),
                director.getPassword(),
                null
        );
    }
    }
