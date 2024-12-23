package com.switchfully.parkshark_2024_10.division;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DivisionRepository extends JpaRepository<Division, Long> {

    @Query("SELECT d FROM Division d")
    List<Division> getAllDivisions();
}