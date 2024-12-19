package com.switchfully.parkshark_2024_10.address;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
    private long id;
    @Column(name = "street")
    private  String street;
    @Column(name = "number")
    private  int number;
    @Column(name = "extra")
    private  String extra;
    @OneToOne
    @JoinColumn(name = "code")
    private  Zip zipCode;

    public Address(String street, int number, String extra, Zip zipCode) {
        this.street = street;
        this.number = number;
        this.extra = extra;
        this.zipCode = zipCode;
    }

    public Address() {
        // DESERIALIZATION
    }

    public long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getExtra() {
        return extra;
    }

    public Zip getZipCode() {
        return zipCode;
    }
}
