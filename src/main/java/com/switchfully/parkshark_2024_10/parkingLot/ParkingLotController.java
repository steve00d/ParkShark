package com.switchfully.parkshark_2024_10.parkingLot;

import com.switchfully.parkshark_2024_10.auth.AuthService;
import com.switchfully.parkshark_2024_10.auth.Permission;
import com.switchfully.parkshark_2024_10.exceptions.UnauthorizedException;
import com.switchfully.parkshark_2024_10.user.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/parkinglot")
public class ParkingLotController {
    ParkingLotService parkingLotService;
    AuthService authService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping(value = "", consumes = "application/json", produces = "application/json")
    public ParkingLotDto createParkingLot(@RequestBody CreateParkingLotDto createParkingLotDto, @RequestHeader String token) {
        Person person = authService.userAuthenticated(token);
        if (!person.hasPermission(Permission.CAN_CREATE_PARKING_LOTS)) {
            throw new UnauthorizedException();
        }
        return parkingLotService.createParkingLot(createParkingLotDto);
    }


}
