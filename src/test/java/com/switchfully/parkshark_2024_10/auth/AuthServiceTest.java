package com.switchfully.parkshark_2024_10.auth;

import com.switchfully.parkshark_2024_10.exceptions.UnauthorizedException;
import com.switchfully.parkshark_2024_10.user.Person;
import com.switchfully.parkshark_2024_10.user.UserService;
import org.junit.jupiter.api.AutoClose;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class AuthServiceTest {

    @Autowired
    private AuthService authService;

    @MockitoSpyBean
    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);
        authService = new AuthService(userService);
    }

    @Test
    void extractCredentials_validHeader_returnsCredentials() {
        // given
        String username = "testuser";
        String password = "password";
        String authHeader = "Basic " + java.util.Base64.getEncoder().encodeToString((username + ":" + password).getBytes());

        // when
        String[] credentials = authService.extractCredentials(authHeader);

        // then
        assertEquals(2, credentials.length);
        assertEquals(username, credentials[0]);
        assertEquals(password, credentials[1]);
    }

    @Test
    void extractCredentials_nullHeader_throwsException() {
        // when and then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> authService.extractCredentials(null));
        assertEquals("Invalid Authorization header", exception.getMessage());
    }

    @Test
    void extractCredentials_invalidPrefix_throwsException() {
        // when
        String authHeader = "Bearer token";

        // then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> authService.extractCredentials(authHeader));
        assertEquals("Invalid Authorization header", exception.getMessage());
    }

    @Test
    void extractCredentials_invalidTokenFormat_throwsException() {
        // givne
        String authHeader = "Basic " + java.util.Base64.getEncoder().encodeToString("invalidToken".getBytes());

        // when then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> authService.extractCredentials(authHeader));
        assertEquals("Invalid token format", exception.getMessage());
    }

    @Test
    void userAuthenticated_validCredentials_returnsPerson() {
        // given
        String username = "testuser";
        String password = "password";
        String authHeader = "Basic " + java.util.Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
        Person mockPerson = mock(Person.class);
        when(userService.authenticate(username, password)).thenReturn(mockPerson);

        // when
        Person result = authService.userAuthenticated(authHeader);

        // then
        assertNotNull(result);
        assertEquals(mockPerson, result);
        verify(userService, times(1)).authenticate(username, password);
    }

    @Test
    void userAuthenticated_invalidCredentials_throwsUnauthorizedException() {
        // given
        String username = "testuser";
        String password = "wrongpassword";
        String authHeader = "Basic " + java.util.Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
        when(userService.authenticate(username, password)).thenThrow(new UnauthorizedException());

        // when & then
        UnauthorizedException exception = assertThrows(UnauthorizedException.class,
                () -> authService.userAuthenticated(authHeader));
        assertEquals("Unauthorized", exception.getMessage());
        verify(userService, times(1)).authenticate(username, password);
    }
}
