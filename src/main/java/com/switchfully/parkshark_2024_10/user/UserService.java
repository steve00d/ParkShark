package com.switchfully.parkshark_2024_10.user;


import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public Person authenticate(String username, String password) {
        return findByCredentials(username, password);

    }

    private Person findByCredentials(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }


}
