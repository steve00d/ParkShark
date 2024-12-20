package com.switchfully.parkshark_2024_10.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Person, Long> {


    Person findByEmailAndPassword(String email, String password);

    Person findByName(String bert);
}
