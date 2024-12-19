package domain;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("1")
public class Director extends Person{

       @Column(name="FIRST_NAME")
       private String first_name;

       @Column(name="LAST_NAME")
       private String last_name;


       @OneToOne
       @JoinColumn(name="FK_DIVISION_ID")
       private Division division;


    public Director(String first_name, String last_name, Division division) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.division = division;
    }

    public Director() {

    }


    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Division getDivision() {
        return division;
    }
}
