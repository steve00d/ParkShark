package com.switchfully.parkshark_2024_10.user;


import com.switchfully.parkshark_2024_10.auth.Role;
import com.switchfully.parkshark_2024_10.division.Division;
import org.h2.engine.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@DataJpaTest
public class CreateUserTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;


    @Test
    void savePerson(){
        //userRepository.save(new Director(new Division(), "Bert", "Poelmans", "br@be.com", "pwd"));

        Director director = new Director(new Division(), "Bert", "Poelmans", "br@be.com", "pwd");


        //when
        entityManager.persist(director);

        Director found = (Director) userRepository.findByName("Bert");

        Assertions.assertEquals(director.getId(),(found.getId()));

    }
}
