package com.switchfully.parkshark_2024_10.parkingLot;

import domain.address.Address;
import domain.contactInformation.ContactInformation;
import jakarta.persistence.*;

@Entity
@Table(name = "parking_lot")
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking_lot_seq")
    @SequenceGenerator(name = "parking_lot_seq", sequenceName = "parking_lot_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "parking_lot_category")
    private ParkingLotCategory parkingLotCategory;

    @Column(name = "capacity")
    private int Capacity;

    @OneToOne
    @JoinColumn(name = "contact_information")
    private ContactInformation contactPerson;

    @OneToOne
    @JoinColumn(name = "address")
    private Address address;

    @Column(name = "price_per_hour")
    private double pricePerHour;

    public ParkingLot(Long id, String name, ParkingLotCategory parkingLotCategory, int capacity, ContactInformation contactPerson, Address address, double pricePerHour) {
        this.id = id;
        this.name = name;
        this.parkingLotCategory = parkingLotCategory;
        this.Capacity = capacity;
        this.contactPerson = contactPerson;
        this.address = address;
        this.pricePerHour = pricePerHour;
    }

    public ParkingLot() {
        // DESERIALIZATION
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

    public Address getAddress() {
        return address;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }
}
