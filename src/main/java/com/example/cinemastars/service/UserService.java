package com.example.cinemastars.service;

import com.example.cinemastars.model.User;

public interface UserService {
    public User save(String username, String password, String name, String surname);
    public User findById(String username);
}
