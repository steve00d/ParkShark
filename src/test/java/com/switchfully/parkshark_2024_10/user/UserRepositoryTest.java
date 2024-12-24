package com.switchfully.parkshark_2024_10.user;

import com.switchfully.parkshark_2024_10.division.Division;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Base64;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private String encodedPassword;
    @BeforeEach
    void setUp(){
        encodedPassword = Base64.getEncoder().encodeToString("pwd".getBytes());
    }

    @Test
    void findByEmailAndPassword_shouldReturnCorrectPerson() {
        // given
        Division division = new Division("findByEmailAndPassword_shouldReturnCorrectPerson");


        Director director = new Director("Jane", "Doe", "jane.doe@parkshark.com", encodedPassword, division);
        userRepository.save(director);

        // When
        Person found = userRepository.findByEmailAndPassword("jane.doe@parkshark.com", encodedPassword);

        //then
        Assertions.assertNotNull(found, "Person should not be null");
        Assertions.assertEquals(director.getId(), found.getId(), "Person IDs should match");
        Assertions.assertEquals("Jane", found.getFirstName(), "First names should match");
        Assertions.assertEquals("Doe", found.getLastName(), "Last names should match");
        Assertions.assertEquals("jane.doe@parkshark.com", found.getEmail(), "Emails should match");
    }

    @Test
    void findByEmailAndPassword_shouldReturnNullWhenCredentialsDoNotMatch() {
        // when
        Division division = new Division("findByEmailAndPassword_shouldReturnNullWhenCredentialsDoNotMatch");


        String wrongEncodedPassword = Base64.getEncoder().encodeToString("wrongPAssword".getBytes());
        Director director = new Director("John", "Smith", "john.smith@parjshark.com", encodedPassword, division);
        userRepository.save(director);

        // when
        Person found = userRepository.findByEmailAndPassword("john.smith@parjshark.com", wrongEncodedPassword);

        // then
        Assertions.assertNull(found, "Person should be null when credentials do not match");
    }

    @Test
    void findByName_shouldReturnCorrectPerson() {
        // given
        Division division = new Division("findByName_shouldReturnCorrectPerson");

        Director director = new Director("Alice", "Johnson", "alice.johnson@parkshark.com", encodedPassword, division);
        userRepository.save(director);

        // when
        Person found = userRepository.findByName("Alice");

        // then
        Assertions.assertNotNull(found, "Person should not be null");
        Assertions.assertEquals(director.getId(), found.getId(), "Person IDs should match");
        Assertions.assertEquals("Alice", found.getFirstName(), "First names should match");
        Assertions.assertEquals("Johnson", found.getLastName(), "Last names should match");
    }
    @Test
    void findByLastName_shouldReturnCorrectPerson() {
        // given
        Division division = new Division("findByLastName_shouldReturnCorrectPerson");

        Director director = new Director("Alice", "Johnson", "alice.johnson@parkshark.com", encodedPassword, division);
        userRepository.save(director);

        // when
        Person found = userRepository.findByName("Johnson");

        // then
        Assertions.assertNotNull(found, "Person should not be null");
        Assertions.assertEquals(director.getId(), found.getId(), "Person IDs should match");
        Assertions.assertEquals("Alice", found.getFirstName(), "First names should match");
        Assertions.assertEquals("Johnson", found.getLastName(), "Last names should match");
    }

    @Test
    void findByName_shouldReturnNullWhenNameDoesNotMatch() {
        // given
        Division division = new Division("findByName_shouldReturnNullWhenNameDoesNotMatch");

        Director director = new Director("Bob", "Williams", "bob.williams@parkshark.com", encodedPassword, division);
        userRepository.save(director);

        // when
        Person found = userRepository.findByName("NonExistentName");

        // then
        Assertions.assertNull(found, "Person should be null when name does not match");
    }
}
