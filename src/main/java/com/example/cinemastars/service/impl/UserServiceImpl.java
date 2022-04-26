package com.example.cinemastars.service.impl;

import com.example.cinemastars.model.Role;
import com.example.cinemastars.model.User;
import com.example.cinemastars.model.exceptions.InvalidUsernameOrPasswordException;
import com.example.cinemastars.model.exceptions.PasswordsDoNotMatchException;
import com.example.cinemastars.model.exceptions.UsernameAlreadyExistsException;
import com.example.cinemastars.repository.SeatRepository;
import com.example.cinemastars.repository.UserRepository;
import com.example.cinemastars.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
    }


    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role userRole) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username,passwordEncoder.encode(password),name,surname,userRole);
        return userRepository.save(user);
    }

}
