package com.switchfully.parkshark_2024_10.user;

import com.switchfully.parkshark_2024_10.auth.Role;
import com.switchfully.parkshark_2024_10.division.Division;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("1")
public class Director extends Person {




       @OneToOne
       @JoinColumn(name="FK_DIVISION_ID")
       private Division division;


    public Director(Division division) {

        this.division = division;
    }

    public Director() {

    }

    public Director(Division division, String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
        this.division = division;

    }

    @Override
    public Role getRole() {
        return null;
    }


    public Division getDivision() {
        return division;
    }
}