package domain.contactInformation;

import domain.address.Address;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "contact_information")
public class ContactInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_information_seq")
    @SequenceGenerator(name = "contact_information_seq", sequenceName = "contact_information_seq", allocationSize = 1)
    private Long id;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @NotBlank
    @Column(name = "primary_phone_number")
    private String primaryPhoneNumber;

    @Nullable
    @Column(name = "secondary_phone_number")
    private String secondaryPhoneNumber;

    @NotBlank
    @Email(message = "Invalid email address")
    @Column(name = "email_address")
    private String emailAddress;

    @NotNull
    @OneToOne
    @JoinColumn(name = "fk_address_id")
    private Address address;

    public ContactInformation(
            String firstName,
            String lastName,
            String primaryPhoneNumber,
            String secondaryPhoneNumber,
            String emailAddress,
            Address address
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.primaryPhoneNumber = primaryPhoneNumber;
        this.secondaryPhoneNumber = secondaryPhoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
    }

    public ContactInformation() {
        // DESERIALIZATION
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPrimaryPhoneNumber() {
        return primaryPhoneNumber;
    }

    public String getSecondaryPhoneNumber() {
        return secondaryPhoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Address getAddress() {
        return address;
    }
}
