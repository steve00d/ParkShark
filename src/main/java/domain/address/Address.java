package domain.address;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private int number;

    @Column(name = "extra")
    private String extra;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Zip.class)
    @JoinColumn(name = "fk_zip_code", nullable = false)
    private Zip zipCode;

    public Address(String street, int number, String extra, Zip zipCode) {
        this.street = street;
        this.number = number;
        this.extra = extra;
        this.zipCode = zipCode;
    }

    public Address() {
        // DESERIALIZATION
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getExtra() {
        return extra;
    }

    public Zip getZipCode() {
        return zipCode;
    }
}
