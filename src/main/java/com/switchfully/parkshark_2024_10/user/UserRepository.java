package com.switchfully.parkshark_2024_10.user;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.email = :email AND p.password = :password")
    Person findByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("SELECT p FROM Person p WHERE concat(p.firstName, ' ', p.lastName) like concat('%', :name, '%')")
    Person findByName(@Param("name") String name);
}
