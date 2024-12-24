package com.switchfully.parkshark_2024_10.user;

import com.switchfully.parkshark_2024_10.auth.Role;
import com.switchfully.parkshark_2024_10.division.Division;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("1")
public class Director extends Person {

    @OneToOne(mappedBy = "director", cascade = CascadeType.ALL)
    private Division division;

    public Director(String firstName, String lastName, String email, String password, Division division) {
        super(firstName, lastName, email, password);
        this.division = division;
    }

    public Director(Division division) {
        this.division = division;
    }

    public Director() {
        // JACKSON
    }

    @Override
    public Role getRole() {
        return null;
    }

    public Division getDivision() {
        return division;
    }

}
