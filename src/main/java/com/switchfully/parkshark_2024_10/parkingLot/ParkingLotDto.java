package com.switchfully.parkshark_2024_10.parkingLot;

import domain.address.AddressDto;
import domain.contactInformation.ContactInformation;
import lombok.Value;

import java.io.Serializable;


public class ParkingLotDto{
    Long id;
    String name;
    ParkingLotCategory parkingLotCategory;
    int Capacity;
    ContactInformation contactPerson;
    AddressDto address;
    double pricePerHour;


    public ParkingLotDto(Long id, String name, ParkingLotCategory parkingLotCategory, int capacity, ContactInformation contactPerson, AddressDto address, double pricePerHour) {
        this.id = id;
        this.name = name;
        this.parkingLotCategory = parkingLotCategory;
        Capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ParkingLotCategory getParkingLotCategory() {
        return parkingLotCategory;
    }

    public int getCapacity() {
        return Capacity;
    }

    public ContactInformation getContactPerson() {
        return contactPerson;
    }

    public AddressDto getAddress() {
        return address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
}