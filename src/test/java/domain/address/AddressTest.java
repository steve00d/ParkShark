package domain.address;

import com.switchfully.parkshark_2024_10.address.Address;
import com.switchfully.parkshark_2024_10.address.Zip;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AddressTest {

    Address address;
    Zip zip;

    @Test
    void constructor() {
        zip = new Zip("1000", "Brussels", domain.address.CountryCode.BE);
        address = new Address("street", 1, "extra", zip);

        assertNull(address.getId());
        assertEquals("street", address.getStreet());
        assertEquals(1, address.getNumber());
        assertEquals("extra", address.getExtra());
        assertEquals(zip, address.getZipCode());
    }
}