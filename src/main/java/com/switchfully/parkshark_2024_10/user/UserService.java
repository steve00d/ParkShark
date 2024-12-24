package com.switchfully.parkshark_2024_10.user;


import com.switchfully.parkshark_2024_10.exceptions.UnauthorizedException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Person authenticate(String username, String password) {
        return Optional.ofNullable(findByCredentials(username, password))
                .or(() -> {
                    String encoded = Base64.getEncoder().encodeToString(password.getBytes());

                    return Optional.ofNullable(findByCredentials(username, encoded));
                })
                .orElseThrow(UnauthorizedException::new);
    }

    private Person findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
