package com.example.metaphorce.service;

import com.example.metaphorce.model.Tienda;
import com.example.metaphorce.model.User;
import com.example.metaphorce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public void newUser(User user) {
        this.userRepository.save(user);
    };
}
