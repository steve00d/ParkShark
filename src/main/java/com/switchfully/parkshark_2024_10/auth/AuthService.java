package com.switchfully.parkshark_2024_10.auth;

import com.switchfully.parkshark_2024_10.exceptions.UnauthorizedException;
import com.switchfully.parkshark_2024_10.user.Person;
import com.switchfully.parkshark_2024_10.user.UserService;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private static final String PREFIX = "Basic ";
    private static final String SEPARATOR = ":";
    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public String[] extractCredentials(String authHeader) {
        if (authHeader == null || !authHeader.startsWith(PREFIX)) {
            throw new IllegalArgumentException("Invalid Authorization header");
        }

        String base64Token = authHeader.substring(PREFIX.length());
        String token = convertToken(base64Token);

        String[] credentials = token.split(SEPARATOR, 2);
        if (credentials.length != 2) {
            throw new IllegalArgumentException("Invalid token format");
        }

        return credentials;
    }

    private static String convertToken(String base64Token) {
        return new String(java.util.Base64.getDecoder().decode(base64Token));
    }

    public Person userAuthenticated(String authHeader) {
        String[] credentials = extractCredentials(authHeader);
        String username = credentials[0];
        String password = credentials[1];

        return userService.authenticate(username, password);
    }
}
