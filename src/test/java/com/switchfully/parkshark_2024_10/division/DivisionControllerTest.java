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
import org.springframework.test.context.bean.override.mockito.MockitoBean;
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

    @MockitoBean
    AuthService authService;

    @Test
    @DisplayName("Division can be created as manager")
    void addDivisionAsManager() {
        Manager manager = new Manager("manaa", "geeer", "manager@gmail.com", "1234");
        String token = "Basic " + Base64.getEncoder()
                .encodeToString((manager.getEmail() + ":" + manager.getPassword()).getBytes());
        Mockito.when(authService.userAuthenticated(token)).thenReturn(manager);

        String body = """
                {
                  "name": "test",
                  "director": {
                    "firstName": "Smetje",
                    "lastName": "Smetvrees",
                    "email": "test@foo.be",
                    "password": "test"
                  },
                  "originalCompanyName": "test company"
                }
                """;

        DivisionDto response = RestAssured.given()
                .header("Authorization", token)
                .contentType("application/json")
                .body(body)
                .when()
                .post("/api/division")
                .then()
                .statusCode(201)
                .extract()
                .body()
                .as(DivisionDto.class);

        assertNotNull(response);
        assertEquals("test", response.getName());
        assertEquals("test@foo.be", response.getDirectorDto().getEmail());
        assertEquals("Smetje", response.getDirectorDto().getFirstName());
        assertEquals("Smetvrees", response.getDirectorDto().getLastName());
        assertEquals("test company", response.getOriginalCompanyName());
    }


}
