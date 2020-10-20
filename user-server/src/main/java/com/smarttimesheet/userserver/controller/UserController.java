package com.smarttimesheet.userserver.controller;

import com.smarttimesheet.userserver.model.User;
import com.smarttimesheet.userserver.repo.ContactRepository;
import com.smarttimesheet.userserver.repo.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ContactRepository contactRepository;

    private static final Logger logger = LogManager.getLogger(UserController.class);


    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // This function is used for login
    @GetMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam String email, @RequestParam String password) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                logger.info("Success login");
                return new ResponseEntity<>(true, HttpStatus.OK);
            }
            logger.info("Fail: wrong email or password");
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
//            return user.getPassword().equals(password);
        }
        logger.info("Fail: wrong email or password");
        return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
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
