package com.switchfully.parkshark_2024_10.address;

import jakarta.persistence.*;

@Entity
@Table(name = "zip_code")
public class Zip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zip_code_seq")
    @SequenceGenerator(name = "zip_code_seq", sequenceName = "zip_code_seq", allocationSize = 1)
    private Long id;
    @Column(name = "code")
    private String code;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;

    public Zip(String code, String city, String state) {
        this.code = code;
        this.city = city;
        this.state = state;
    }

    public Zip() {
        // DESERIALIZATION
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
