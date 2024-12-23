package com.switchfully.parkshark_2024_10.division;


import com.switchfully.parkshark_2024_10.auth.AuthService;
import com.switchfully.parkshark_2024_10.director.dto.CreateDirectorDto;
import com.switchfully.parkshark_2024_10.division.dto.CreateDivisionDto;
import com.switchfully.parkshark_2024_10.division.dto.DivisionDto;
import com.switchfully.parkshark_2024_10.user.Manager;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Base64;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase
class DivisionControllerTest {


    @MockitoBean
    AuthService authService;
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

    @Test
    @DisplayName("Get all divisions as manager")
    void getAllDivisions_AsManager_returnsAListOfDivisionDtos() {
        // when

        String encodedPassword = Base64.getEncoder().encodeToString("pwd".getBytes());
        Manager manager = new Manager("Jane", "Doe", "jane.doe@gmail.com", encodedPassword);
        CreateDirectorDto director1 = new CreateDirectorDto("Director1", "Last1", "dir1@gmail.com", "password1", null);
        CreateDirectorDto director2 = new CreateDirectorDto("Director2", "Last2", "dir2@gmail.com", "password2", null);

        CreateDivisionDto division1 = new CreateDivisionDto("Division One", director1, "Old Company 1");
        CreateDivisionDto division2 = new CreateDivisionDto("Division Two", director2, "Old Company 2");

        String token = "Basic " + Base64.getEncoder()
                .encodeToString((manager.getEmail() + ":" + manager.getPassword()).getBytes());


        RestAssured.given()
                .header("Authorization", token)
                .contentType("application/json")
                .body(division1)
                .when()
                .post("/api/division")
                .then()
                .statusCode(201);


        RestAssured.given()
                .header("Authorization", token)
                .contentType("application/json")
                .body(division2)
                .when()
                .post("/api/division")
                .then()
                .statusCode(201);


        List<DivisionDto> divisions = RestAssured.given()
                .header("Authorization", token)
                .contentType("application/json")
                .when()
                .get("/api/division")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .as(new TypeRef<List<DivisionDto>>() {
                });


        assertThat(divisions).hasSize(2);

        DivisionDto firstDivision = divisions.get(0);
        assertEquals("Division One", firstDivision.getName());
        assertEquals("Director1", firstDivision.getDirectorDto().getFirstName());

        DivisionDto secondDivision = divisions.get(1);
        assertEquals("Division Two", secondDivision.getName());
        assertEquals("Director2", secondDivision.getDirectorDto().getFirstName());
    }

}
