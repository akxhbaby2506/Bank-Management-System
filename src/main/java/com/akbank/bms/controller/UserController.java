package com.akbank.bms.controller;

import com.akbank.bms.entity.User;
import com.akbank.bms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Code Cleanup
import com.akbank.bms.dto.UserDTO;
import com.akbank.bms.util.UserMapper;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user  (Before Code Cleanup)
//    @PostMapping
//    public ResponseEntity<User> createUser(@RequestBody User user) {
//        User createdUser = userService.createUser(user);
//        return ResponseEntity.ok(createdUser);
//    }
    
    // Create a new user (After Code Cleanup)
    // Updated createUser for Code Cleanup
    
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }


    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userOpt = userService.getUserById(id);
        return userOpt.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // Get user by Account Number
    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<User> getUserByAccountNumber(@PathVariable String accountNumber) {
        Optional<User> userOpt = userService.getUserByAccountNumber(accountNumber);
        return userOpt.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    // Update user by ID (before Code Cleanup)
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
//        try {
//            User user = userService.updateUser(id, updatedUser);
//            return ResponseEntity.ok(user);
//        } catch (RuntimeException ex) {
//            return ResponseEntity.notFound().build();
//        }
//    }
    
    // For Code Cleanup (After Code Cleanup)
    // Updated Code for Code Cleanup
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO updatedUserDTO) {
        try {
            User updatedUser = UserMapper.toEntity(updatedUserDTO);
            User user = userService.updateUser(id, updatedUser);
            return ResponseEntity.ok(user);
        } catch (RuntimeException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    
    

    // Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    // Delete user by Account Number
//    @DeleteMapping("/account/{accountNumber}")
//    public ResponseEntity<Void> deleteUserByAccountNumber(@PathVariable String accountNumber) {
//        try {
//            userService.deleteUserByAccountNumber(accountNumber);
//            return ResponseEntity.noContent().build();
//        } catch (RuntimeException ex) {
//            return ResponseEntity.notFound().build();
//        }
//    }
    
    @GetMapping("/check/account/{accountNumber}")
    public ResponseEntity<?> checkAccount(@PathVariable String accountNumber) {
        System.out.println("Received account number: " + accountNumber);
        return ResponseEntity.ok(userService.getUserByAccountNumber(accountNumber));
    }
    
    @DeleteMapping("/account/{accountNumber}")
    public ResponseEntity<Void> deleteUserByAccountNumber(@PathVariable String accountNumber) {
        System.out.println("Trying to delete account: " + accountNumber);

        Optional<User> user = userService.getUserByAccountNumber(accountNumber);

        if (user.isPresent()) {
            userService.deleteUserByAccountNumber(accountNumber);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
