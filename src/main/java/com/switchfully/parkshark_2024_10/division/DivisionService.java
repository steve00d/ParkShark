package com.switchfully.parkshark_2024_10.division;

import com.switchfully.parkshark_2024_10.division.dto.CreateDivisionDto;
import com.switchfully.parkshark_2024_10.division.dto.DivisionDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DivisionService {
    DivisionRepository divisionRepository;

    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public DivisionDto addDivision(CreateDivisionDto createDivisionDto){
        Division division = DivisionMapper.mapToDivision(createDivisionDto);
        divisionRepository.save(division);
        return DivisionMapper.mapToDivisionDto(division);
    }

    public List<DivisionDto> getAllDivisions(){
        List<Division> divisions = divisionRepository.getAllDivisions();
        return divisions.stream().map(DivisionMapper::mapToDivisionDto).toList();
    }

}
