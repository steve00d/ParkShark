package domain.adress;

import jakarta.persistence.*;

@Entity
@Table(name = "adress")
public class Adress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
    private long id;
    @Column(name = "street")
    private  String street;
    @Column(name = "number")
    private  int number;
    @Column(name = "extra")
    private  String extra;
    @OneToOne
    @JoinColumn(name = "code")
    private  Zip zipCode;

    public Adress(String street, int number, String extra, Zip zipCode) {
        this.street = street;
        this.number = number;
        this.extra = extra;
        this.zipCode = zipCode;
    }

    public Adress() {
        // DESERIALIZATION
    }

    public long getId() {
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
