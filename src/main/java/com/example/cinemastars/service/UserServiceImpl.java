package com.example.cinemastars.service;

import com.example.cinemastars.model.User;
import com.example.cinemastars.repository.SeatRepository;
import com.example.cinemastars.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(String username, String password, String name, String surname) {
        User user=new User(name, surname, username, password);
        return userRepository.save(user);
    }

    @Override
    public User findById(String username) {
        return userRepository.getById(username);
    }

}
