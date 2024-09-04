package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean registerUser(String email, String password) {
        System.out.println(isEmailValid(email));
        if (email == null || !isEmailValid(email)) return false;
        if (password == null || password.length() < 8) return false;

        User user = new User(email, password);
        userRepository.save(user);
        return true;
    }

    public boolean isEmailValid(String email) {
        return email.contains("@") && email.substring(email.indexOf("@")).contains(".");
    }

    
}
