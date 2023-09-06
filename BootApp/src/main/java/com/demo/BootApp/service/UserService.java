package com.demo.BootApp.service;

import com.demo.BootApp.DTO.UserRequest;
import com.demo.BootApp.exception.UserNotFoundException;
import com.demo.BootApp.model.User;

import java.util.List;

public interface UserService {
    public User saveUser(UserRequest user);

    public List<User> getAllUsers();

    public User getUser(int id) throws UserNotFoundException;
}
