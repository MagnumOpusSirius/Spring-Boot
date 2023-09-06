package com.demo.BootApp.service;

import com.demo.BootApp.DTO.UserRequest;
import com.demo.BootApp.dao.UserRepository;
import com.demo.BootApp.exception.UserNotFoundException;
import com.demo.BootApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(UserRequest userRequest) {
        //how to save userRequest to save user in database? Ans: use User.build() method
        //where is this user build method? Ans: in User.java
        //which class does build method belong to? Ans: User.java

        User user = User.build(0, userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) throws UserNotFoundException {
        User user= userRepository.findByUserId(id);
        if(user != null)
            return user;
        else
            throw new UserNotFoundException("User not found with id : " + id);
    }
}
