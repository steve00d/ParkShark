package com.switchfully.parkshark_2024_10.parkingLot.dto;

import com.switchfully.parkshark_2024_10.parkingLot.ParkingLotCategory;
import domain.address.Address;
import domain.address.AddressDto;
import domain.contactInformation.ContactInformation;

public class CreateParkingLotDto {
    private final String name;
    private final ParkingLotCategory parkingLotCategory;
    private final int capacity;
    private final ContactInformationDto contactPerson;
    private final AddressDto address;
    private final double pricePerHour;

    public CreateParkingLotDto(String name, ParkingLotCategory parkingLotCategory, int capacity, ContactInformationDto contactPerson, AddressDto address, double pricePerHour) {
        this.name = name;
        this.parkingLotCategory = parkingLotCategory;
        this.capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
    }

    public String getName() {
        return name;
    }

    public ParkingLotCategory getParkingLotCategory() {
        return parkingLotCategory;
    }

    public int getCapacity() {
        return capacity;
    }

    public ContactInformation getContactPerson() {
        return contactPerson;
    }

    public Address getAddress() {
        return address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
}
