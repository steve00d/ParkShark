package com.switchfully.parkshark_2024_10.division;


import com.switchfully.parkshark_2024_10.division.dto.CreateDirectorDto;
import com.switchfully.parkshark_2024_10.division.dto.CreateDivisionDto;
import com.switchfully.parkshark_2024_10.division.dto.DivisionDto;
import com.switchfully.parkshark_2024_10.user.Manager;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DivisionControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    @DisplayName("Division can be created as manager")
    void addDivisionAsManager() {
        Manager manager = new Manager("manaa", "geeer", "manager@gmail.com", "1234");
        CreateDirectorDto director = new CreateDirectorDto("steve", "daenen",
                "steve@gmail.com", "1234");
        CreateDivisionDto createDivisionDto = new CreateDivisionDto(
                "Division 1", director, "old company");

        String token = "Basic " + Base64.getEncoder()
                .encodeToString((manager.getEmail() + ":" + manager.getPassword()).getBytes());

        DivisionDto response = RestAssured.given()
                .header("Authorization", token)
                .contentType("application/json")
                .body(createDivisionDto)
                .when()
                .post("/api/division")
                .then()
                .statusCode(201)
                .extract()
                .body()
                .as(DivisionDto.class);

        assertNotNull(response);
        assertEquals(createDivisionDto.getName(), response.getName());
        assertEquals(createDivisionDto.getCreateDirectorDto().getEmail(), response.getDirectorDto().getEmail());
        assertEquals(createDivisionDto.getCreateDirectorDto().getFirstName(), response.getDirectorDto().getFirstName());
        assertEquals(createDivisionDto.getCreateDirectorDto().getLastName(), response.getDirectorDto().getLastName());
        assertEquals(createDivisionDto.getOriginalCompanyName(), response.getOriginalCompanyName());
    }


}
