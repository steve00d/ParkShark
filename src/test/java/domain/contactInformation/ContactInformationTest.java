package domain.contactInformation;

import com.switchfully.parkshark_2024_10.address.Address;
import com.switchfully.parkshark_2024_10.address.Zip;
import com.switchfully.parkshark_2024_10.contactInformation.ContactInformation;
import domain.address.CountryCode;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ContactInformationTest {

    Zip zip = new Zip(
            "1000",
            "Brussels",
            CountryCode.BE
    );

    Address address = new Address(
            "street",
            12,
            "B01",
            zip
    );

    @Test
    void constructor() {
        ContactInformation contactInformation = new ContactInformation(
                "firstname",
                "lastname",
                "555-4354",
                null,
                "foo@bar.be",
                address
        );

        assertNull(contactInformation.getId());
        assertEquals("firstname", contactInformation.getFirstName());
        assertEquals("lastname", contactInformation.getLastName());
        assertEquals("555-4354", contactInformation.getPrimaryPhoneNumber());
        assertNull(contactInformation.getSecondaryPhoneNumber());
        assertEquals("foo@bar.be", contactInformation.getEmailAddress());
        assertEquals(address, contactInformation.getAddress());
    }

    @Nested
    class validation {
        private void validate(ContactInformation contactInformation, String fieldName, String value) {
            try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
                Set<ConstraintViolation<ContactInformation>> violations = factory.getValidator().validate(contactInformation);

                assertEquals(1, violations.size());
                violations.stream().findFirst().ifPresent((violation) -> {
                    assertEquals(value, violation.getInvalidValue());
                    assertEquals(fieldName, violation.getPropertyPath().toString());
                });
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        @Test
        void validateFirstName() {
            ContactInformation contactInformation = new ContactInformation(
                    "",
                    "lastname",
                    "555-4354",
                    null,
                    "foo@bar.be",
                    address
            );

            validate(contactInformation, "firstName", "");
        }

        @Test
        void validateLastName() {
            ContactInformation contactInformation = new ContactInformation(
                    "firstname",
                    "",
                    "555-4354",
                    null,
                    "foo@bar.be",
                    address
            );

            validate(contactInformation, "lastName", "");
        }

        @Test
        void validatePrimaryPhoneNumber() {
            ContactInformation contactInformation = new ContactInformation(
                    "firstname",
                    "lastname",
                    "",
                    null,
                    "foo@bar.be",
                    address
            );

            validate(contactInformation, "primaryPhoneNumber", "");
        }

        @Test
        void validateEmailAddressNotBlank() {
            ContactInformation contactInformation = new ContactInformation(
                    "firstname",
                    "lastname",
                    "555-4354",
                    null,
                    "",
                    address
            );

            validate(contactInformation, "emailAddress", "");
        }

        @Test
        void validateEmailAddressNotValid() {
            ContactInformation contactInformation = new ContactInformation(
                    "firstname",
                    "lastname",
                    "555-4354",
                    null,
                    "foo",
                    address
            );

            validate(contactInformation, "emailAddress", "foo");
        }

        @Test
        void validateAddress() {
            ContactInformation contactInformation = new ContactInformation(
                    "firstname",
                    "lastname",
                    "555-4354",
                    null,
                    "foo@bar.be",
                    null
            );

            validate(contactInformation, "address", null);
        }
    }
}