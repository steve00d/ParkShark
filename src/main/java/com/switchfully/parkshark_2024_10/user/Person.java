package com.switchfully.parkshark_2024_10.user;


import com.switchfully.parkshark_2024_10.auth.Permission;
import com.switchfully.parkshark_2024_10.auth.Role;
import jakarta.persistence.*;

@Entity
@Table(name = "\"user\"")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_type",
discriminatorType = DiscriminatorType.INTEGER)
public abstract class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(sequenceName = "user_seq", allocationSize = 1, name = "user_seq")
    private Long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="EMAIL")
    private String email;

    @Column(name="password")
    private String password;

    public Person() {
    }

    public Person(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String getFirst_name() {
        return firstName;
    }

    public String getLast_name() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public abstract Role getRole();

    public boolean hasRole(Role role) {
        return getRole().equals(role);
    }

    public boolean hasPermission(Permission permission) {
        return getRole().hasPermission(permission);
    }


}
