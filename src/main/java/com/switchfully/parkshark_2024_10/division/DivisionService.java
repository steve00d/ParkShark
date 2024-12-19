package com.switchfully.parkshark_2024_10.division;

import com.switchfully.parkshark_2024_10.division.dto.CreateDivisionDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DivisionService {
    DivisionRepository divisionRepository;
    DivisionMapper divisionMapper = new DivisionMapper();

    public DivisionService(DivisionRepository divisionRepository) {
        this.divisionRepository = divisionRepository;
    }

    public void addDivision(CreateDivisionDto createDivisionDto){
        Division division = divisionMapper.mapToDivision(createDivisionDto);
        divisionRepository.save(division);
    }

}
