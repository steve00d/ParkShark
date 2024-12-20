package com.switchfully.parkshark_2024_10.division;

import com.switchfully.parkshark_2024_10.division.dto.CreateDivisionDto;
import com.switchfully.parkshark_2024_10.division.dto.DivisionDto;
import com.switchfully.parkshark_2024_10.user.Director;
import com.switchfully.parkshark_2024_10.user.Manager;
import com.switchfully.parkshark_2024_10.user.Person;
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
        RestAssured.port = 8080;
    }

    @Test
    @DisplayName("Division can be created as manager")
    void addDivisionAsManager() {
        Manager manager = new Manager("manaa", "geeer", "manager@gmail.com", "1234");
        Director director = new Director("steve", "daenen",
                "steve@gmail.com", "1234", null);
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
        assertEquals(createDivisionDto.getDirector().getEmail(), response.getDirector().getEmail());
        assertEquals(createDivisionDto.getDirector().getFirst_name(), response.getDirector().getFirst_name());
        assertEquals(createDivisionDto.getDirector().getLast_name(), response.getDirector().getLast_name());
        assertEquals(createDivisionDto.getOriginalCompanyName(), response.getOriginalCompanyName());
    }


}
