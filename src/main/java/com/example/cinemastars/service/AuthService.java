package com.example.cinemastars.service;

import com.example.cinemastars.model.User;

public interface AuthService {
    User login(String username, String password);
}
