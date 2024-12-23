package com.switchfully.parkshark_2024_10.parkingLot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
  }