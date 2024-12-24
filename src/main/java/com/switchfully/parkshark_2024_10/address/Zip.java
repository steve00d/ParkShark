package com.switchfully.parkshark_2024_10.address;

import jakarta.persistence.*;

@Entity
@Table(name = "zip_code")
public class Zip {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "zip_code_seq")
    @SequenceGenerator(name = "zip_code_seq", sequenceName = "zip_code_seq", allocationSize = 1)
    private Long id;

    @Column(name = "zip_code")
    private String code;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private CountryCode country;

    public Zip(String code, String city, CountryCode country) {
        this.code = code;
        this.city = city;
        this.country = country;
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

    public CountryCode getCountry() {
        return country;
    }

    public String getCountryCode() {
        return getCountry().getAlpha2();
    }

    public String getCountryName() {
        return getCountry().getName();
    }
}
