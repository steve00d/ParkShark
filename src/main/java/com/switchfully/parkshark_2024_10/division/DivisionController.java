package com.switchfully.parkshark_2024_10.division;

import com.switchfully.parkshark_2024_10.auth.AuthService;
import com.switchfully.parkshark_2024_10.auth.Permission;
import com.switchfully.parkshark_2024_10.division.dto.CreateDivisionDto;
import com.switchfully.parkshark_2024_10.division.dto.DivisionDto;
import com.switchfully.parkshark_2024_10.exceptions.UnauthorizedException;
import com.switchfully.parkshark_2024_10.user.Person;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/division")
public class DivisionController {
    DivisionService divisionService;
    AuthService authService;

    DivisionController(DivisionService divisionService, AuthService authService) {
        this.divisionService = divisionService;
        this.authService = authService;
    }


    @PostMapping(value = "", produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public DivisionDto addDivision(@RequestBody CreateDivisionDto createDivisionDto, @RequestHeader("Authorization") String token) {
 //       Person user = authService.userAuthenticated(token);
//        if (!user.hasPermission(Permission.CAN_CREATE_DIVISIONS)) {
//            throw new UnauthorizedException();
//        }
       return divisionService.addDivision(createDivisionDto);
    }
}
