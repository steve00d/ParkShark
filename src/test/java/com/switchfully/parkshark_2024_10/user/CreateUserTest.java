package com.switchfully.parkshark_2024_10.user;

import com.switchfully.parkshark_2024_10.division.Division;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Base64;

@DataJpaTest
public class CreateUserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void saveDirector_shouldPersistAndRetrieveDirectorCorrectly() {

        String encodedPassword = Base64.getEncoder().encodeToString("pwd".getBytes());


        Division division = new Division();
        division.setId(1L);
        Director director = new Director(division, "Bert", "Poelmans", "br@be.com", encodedPassword);




        // when
        userRepository.save(director);


        Person found = userRepository.findByName("Bert");

        // then
        Assertions.assertNotNull(found, "Director should not be null after retrieval");
        Assertions.assertEquals(director.getId(), found.getId(), "Director IDs should match");
        Assertions.assertEquals("Bert", found.getFirst_name(), "First names should match");
        Assertions.assertEquals("Poelmans", found.getLast_name(), "Last names should match");
        Assertions.assertEquals("br@be.com", found.getEmail(), "Emails should match");

        Assertions.assertEquals(encodedPassword, found.getPassword(), "Password should be stored encoded");
    }
}
