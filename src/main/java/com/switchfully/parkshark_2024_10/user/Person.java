package com.switchfully.parkshark_2024_10.user;


import com.switchfully.parkshark_2024_10.auth.Permission;
import com.switchfully.parkshark_2024_10.auth.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

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

    @NotBlank
    @Column(name="first_name")
    private String firstName;

    @NotBlank
    @Column(name="last_name")
    private String lastName;

    @NotBlank
    @Email(message = "Email should be valid")
    @Column(name="email")
    private String email;


    @NotBlank
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
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
