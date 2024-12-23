package domain.contactInformation;

import com.switchfully.parkshark_2024_10.parkingLot.ParkingLot;
import domain.address.Address;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "contact_information")
public class ContactInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_information_seq")
    @SequenceGenerator(name = "contact_information_seq", sequenceName = "contact_information_seq", allocationSize = 1)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "primary_phone_number")
    @NotNull
    private String primaryPhoneNumber;

    @Column(name = "secondary_phone_number")
    private String secondaryPhoneNumber;

    @Column(name = "email_address")
    @Email(message = "Invalid email address")
    private String emailAddress;

    @OneToOne
    @JoinColumn (name = "fk_address_id")
    private Address address;

@OneToMany(mappedBy = "contactInformation")
    private List<ParkingLot> parkingLots;

    public ContactInformation(String firstName, String lastName, String primaryPhoneNumber, @Nullable String secondaryPhoneNumber, String emailAddress, Address address) {
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

    public @NotNull String getPrimaryPhoneNumber() {
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

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
}
