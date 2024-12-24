package domain.address;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ZipTest {
    @Test
    void constructor() {
        Zip zip = new Zip("1000", "Brussels", CountryCode.BE);

        assertNull(zip.getId());
        assertEquals("1000", zip.getCode());
        assertEquals("Brussels", zip.getCity());
        assertEquals("BE", zip.getCountryCode());
        assertEquals(CountryCode.BE, zip.getCountry());
        assertEquals("Belgium", zip.getCountryName());
    }
}