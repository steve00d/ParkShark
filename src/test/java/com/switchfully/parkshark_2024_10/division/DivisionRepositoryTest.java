package com.switchfully.parkshark_2024_10.division;


import com.switchfully.parkshark_2024_10.division.dto.DivisionDto;
import com.switchfully.parkshark_2024_10.user.Director;
import com.switchfully.parkshark_2024_10.user.Manager;
import com.switchfully.parkshark_2024_10.user.UserRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Base64;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class DivisionRepositoryTest {

    @Autowired
    private DivisionRepository divisionRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Division can be saved to the database")
    void saveDivision() {
        // given

        String encodedPassword = Base64.getEncoder().encodeToString("pwd".getBytes());
        Director director = new Director("Steve", "Daenen", "steve@gmail.com", encodedPassword, null);
        Manager manager = new Manager("manaa", "geeer", "manager@gmail.com", encodedPassword);

        userRepository.save(manager);
        userRepository.save(director);

        Division division = new Division("Division 1", director, "old company");

        // when
        Division savedDivision = divisionRepository.save(division);

        // then
        assertThat(savedDivision).isNotNull();
        assertThat(savedDivision.getId()).isNotNull();
        assertThat(savedDivision.getName()).isEqualTo("Division 1");
        assertThat(savedDivision.getDirector().getFirstName()).isEqualTo("Steve");
    }


    @Test
    @DisplayName("Get all divisions stored in the database")
    void getAllDivisions_returnsAllPersistedDivisions() {
        // given
        String encodedPassword = Base64.getEncoder().encodeToString("pwd".getBytes());
        Manager manager = new Manager("Jane", "Doe", "janedoe@gmail.com", encodedPassword);
        Director director = new Director("Steve", "Daenen", "steve@gmail.com", encodedPassword, null);
        userRepository.save(manager);
        userRepository.save(director);

        Division division1 = new Division("Division One",director, "Old Company 1");
        Division division2 = new Division("Division Two", director, "Old Company 2");

        divisionRepository.save(division1);
        divisionRepository.save(division2);

        // when fetch all the divisions
        List<Division> divisions = divisionRepository.findAll();


        assertThat(divisions).hasSize(2);

        Division firstDivision = divisions.getFirst();
        assertThat(firstDivision.getName()).isEqualTo("Division One");
        assertThat(firstDivision.getOriginalCompanyName()).isEqualTo("Old Company 1");

        Division secondDivision = divisions.get(1);
        assertThat(secondDivision.getName()).isEqualTo("Division Two");
        assertThat(secondDivision.getOriginalCompanyName()).isEqualTo("Old Company 2");
    }
}

