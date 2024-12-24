package com.switchfully.parkshark_2024_10.division;


import com.switchfully.parkshark_2024_10.auth.AuthService;
import com.switchfully.parkshark_2024_10.director.dto.CreateDirectorDto;
import com.switchfully.parkshark_2024_10.division.dto.CreateDivisionDto;
import com.switchfully.parkshark_2024_10.division.dto.DivisionDto;
import com.switchfully.parkshark_2024_10.user.Manager;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class DivisionControllerTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @MockitoSpyBean
    AuthService authService;

    @Test
    @DisplayName("Division can be created as manager")
    void addDivisionAsManager() {
        Manager manager = new Manager("manaa", "geeer", "manager@gmail.com", "1234");
        String token = "Basic " + Base64.getEncoder()
                .encodeToString((manager.getEmail() + ":" + manager.getPassword()).getBytes());
        Mockito.when(authService.userAuthenticated(token)).thenReturn(manager);

        CreateDirectorDto director = new CreateDirectorDto("steve", "daenen",
                "steve@gmail.com", "1234", null);
        CreateDivisionDto createDivisionDto = new CreateDivisionDto(
                "Division 1", director, "old company");

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
