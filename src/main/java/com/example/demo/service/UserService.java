package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.Wine;
import com.example.demo.model.Winery;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User register(User user);
    User authenticate(String username, String password);
}

