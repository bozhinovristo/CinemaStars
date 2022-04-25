package com.example.cinemastars.service;

import com.example.cinemastars.model.Role;
import com.example.cinemastars.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public User save(String username, String password, String name, String surname);
    public User findById(String username);
    User register(String username, String password, String repeatPassword, String name, String surname, Role role);

}
