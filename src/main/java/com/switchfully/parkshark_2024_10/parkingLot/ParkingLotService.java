package com.switchfully.parkshark_2024_10.parkingLot;

import com.switchfully.parkshark_2024_10.parkingLot.dto.CreateParkingLotDto;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {

ParkingLotRepository parkingLotRepository;

public ParkingLotService(ParkingLotRepository parkingLotRepository) {
this.parkingLotRepository = parkingLotRepository;
}


    public ParkingLot createParkingLot(CreateParkingLotDto createParkingLotDto) {
        return parkingLotRepository.save(new ParkingLot(
                createParkingLotDto.getName(),
                createParkingLotDto.getParkingLotCategory(),
                createParkingLotDto.getCapacity(),
                createParkingLotDto.getContactPerson(),
                createParkingLotDto.getAddress(),
                createParkingLotDto.getPricePerHour()));
    }
}
