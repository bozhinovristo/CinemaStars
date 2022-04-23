package com.example.cinemastars.service;

import com.example.cinemastars.model.User;
import com.example.cinemastars.model.exceptions.InvalidArgumentsException;
import com.example.cinemastars.model.exceptions.InvalidUserCredentialsException;
import com.example.cinemastars.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username,
                password).orElseThrow(InvalidUserCredentialsException::new);
    }
}
