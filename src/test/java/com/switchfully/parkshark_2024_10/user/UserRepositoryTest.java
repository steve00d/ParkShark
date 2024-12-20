package com.switchfully.parkshark_2024_10.user;

import com.switchfully.parkshark_2024_10.division.Division;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void findByEmailAndPassword_shouldReturnCorrectPerson() {
        // given
        Division division = new Division();

        Director director = new Director(division, "Jane", "Doe", "jane.doe@parkshark.com", "password123");
        userRepository.save(director);

        // When
        Person found = userRepository.findByEmailAndPassword("jane.doe@parkshark.com", "password123");

        //then
        Assertions.assertNotNull(found, "Person should not be null");
        Assertions.assertEquals(director.getId(), found.getId(), "Person IDs should match");
        Assertions.assertEquals("Jane", found.getFirst_name(), "First names should match");
        Assertions.assertEquals("Doe", found.getLast_name(), "Last names should match");
        Assertions.assertEquals("jane.doe@parkshark.com", found.getEmail(), "Emails should match");
    }

    @Test
    void findByEmailAndPassword_shouldReturnNullWhenCredentialsDoNotMatch() {
        // when
        Division division = new Division();

        Director director = new Director(division, "John", "Smith", "john.smith@parjshark.com", "securePass");
        userRepository.save(director);

        // when
        Person found = userRepository.findByEmailAndPassword("john.smith@parjshark.com", "wrongPass");

        // then
        Assertions.assertNull(found, "Person should be null when credentials do not match");
    }

    @Test
    void findByName_shouldReturnCorrectPerson() {
        // given
        Division division = new Division();

        Director director = new Director(division, "Alice", "Johnson", "alice.johnson@parkshark.com", "financePass");
        userRepository.save(director);

        // when
        Person found = userRepository.findByName("Alice");

        // then
        Assertions.assertNotNull(found, "Person should not be null");
        Assertions.assertEquals(director.getId(), found.getId(), "Person IDs should match");
        Assertions.assertEquals("Alice", found.getFirst_name(), "First names should match");
        Assertions.assertEquals("Johnson", found.getLast_name(), "Last names should match");
    }

    @Test
    void findByName_shouldReturnNullWhenNameDoesNotMatch() {
        // given
        Division division = new Division();

        Director director = new Director(division, "Bob", "Williams", "bob.williams@parkshark.com", "pwd");
        userRepository.save(director);

        // when
        Person found = userRepository.findByName("NonExistentName");

        // then
        Assertions.assertNull(found, "Person should be null when name does not match");
    }
}
