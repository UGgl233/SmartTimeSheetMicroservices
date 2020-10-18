package com.smarttimesheet.userserver.controller;

import com.smarttimesheet.userserver.model.User;
import com.smarttimesheet.userserver.repo.ContactRepository;
import com.smarttimesheet.userserver.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // This function is used for login
    @GetMapping("/login")
    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user.getPassword().equals(password);
        }
        return false;
    }

    // This function is used for get profile
    @GetMapping("/user/{email}")
    public User getUserByEmail(@PathVariable String email) {
        User user = userRepository.findByEmail(email);
        return user;
    }

    @GetMapping("/userById/{id}")
    public User getUserById(@PathVariable Integer id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @PutMapping("/user/{email}")
    public User updateUser(@PathVariable String email, @RequestBody User userDetail) {
        User user = userRepository.findByEmail(email);

        user.setEmail(userDetail.getEmail());
        user.setAddress(userDetail.getAddress());
        user.setPhone_number(userDetail.getPhone_number());

        User newUser = userRepository.save(user);
        System.out.println(newUser.getEmail());

        return newUser;
    }
}
