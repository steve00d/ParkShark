package com.switchfully.parkshark_2024_10.division;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Division {
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
