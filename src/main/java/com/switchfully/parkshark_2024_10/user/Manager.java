package com.switchfully.parkshark_2024_10.user;

import com.switchfully.parkshark_2024_10.auth.Role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Manager extends Person {
    public Manager(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    public Manager() {
    }

    @Override
    public Role getRole() {
        return Role.MANAGER;
    }
}
