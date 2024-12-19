package com.switchfully.parkshark_2024_10.division;


import jakarta.persistence.*;

@Entity
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "division_seq")
    @SequenceGenerator(name = "division_seq", sequenceName = "division_seq", allocationSize = 1)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne
    @JoinColumn(name = "id")
    private  Director director;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
