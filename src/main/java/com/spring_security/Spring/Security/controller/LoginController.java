package com.spring_security.Spring.Security.controller;

import com.spring_security.Spring.Security.model.User;
import com.spring_security.Spring.Security.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ ")
@CrossOrigin
public class LoginController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user){
        ResponseEntity response = null;
        try {
            String hashPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            User savedUser = userRepo.save(user);
            if (savedUser.getId() > 0){
                response = ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("given user dettail are successfully registered!");
            }
        }catch (Exception e){
            response = ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body("An exception occurred due to " + e.getMessage());
        }
        return response;
    }

}
