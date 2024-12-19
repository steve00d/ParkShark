package domain;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("1")
public class Director extends Person{

       @Column(name="FIRST_NAME")
       private String firstName;

       @Column(name="LAST_NAME")
       private String lastName;


       @OneToOne
       @JoinColumn(name="FK_DIVISION_ID")
       private Division division;


    public Director(String first_name, String last_name, Division division) {
        this.firstName = first_name;
        this.lastName = last_name;
        this.division = division;
    }

    public Director() {

    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Division getDivision() {
        return division;
    }
}
