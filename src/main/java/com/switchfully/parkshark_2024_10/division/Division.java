package com.switchfully.parkshark_2024_10.division;


import com.switchfully.parkshark_2024_10.user.Director;
import jakarta.persistence.*;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "division_seq")
    @SequenceGenerator(name = "division_seq", sequenceName = "division_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_director_id")
    private Director director;

    @Column(name = "original_company_name")
    private String originalCompanyName;

    public Division(String name, Director director, String originalCompanyName) {
        this.name = name;
        this.director = director;
        this.originalCompanyName = originalCompanyName;
    }

    public Division() {

    }

    public String getName() {
        return name;
    }

    public Director getDirector() {
        return director;
    }

    public String getOriginalCompanyName() {
        return originalCompanyName;
    }



    public Long getId() {
        return id;
    }
}
