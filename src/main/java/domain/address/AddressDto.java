package domain.address;

import lombok.Value;

import java.io.Serializable;

public class AddressDto  {
    long id;
    String street;
    int number;
    String extra;
    Zip zipCode;

    public AddressDto(long id, String street, int number, String extra, Zip zipCode) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.extra = extra;
        this.zipCode = zipCode;
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