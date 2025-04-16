package com.akbank.bms.service;

import com.akbank.bms.entity.User;

import com.akbank.bms.repository.UserRepository;
import com.akbank.bms.util.AccountNumberGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Code Cleanup
import com.akbank.bms.exception.*;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	// Creating a new User
	public User createUser(User user) {
		
		String generatedAccNo = AccountNumberGenerator.generate();
		user.setAccountNumber(generatedAccNo);
		return userRepository.save(user);
	}
	
	// Get all users
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	// Get user by ID
	public Optional<User> getUserById(Long id){
		return userRepository.findById(id);
	}
	
	// Update user
	public User updateUser(Long id, User updatedUser) {
		
		Optional<User> optionalUser = userRepository.findById(id);
		
		if (optionalUser.isPresent()) {
			
			User existingUser = optionalUser.get();
			existingUser.setFullName(updatedUser.getFullName());
			existingUser.setEmail(updatedUser.getEmail());
			existingUser.setPassword(updatedUser.getPassword());
			existingUser.setPhone(updatedUser.getPhone());
			existingUser.setBalance(updatedUser.getBalance());
			
			return userRepository.save(existingUser);
		} else {
//			throw new RuntimeException("User not found with ID: " + id);
			throw new UserNotFoundException("User not found with ID: " + id);

		}
	}
	
	// Delete User by Id
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	
	// Find user by account number
	public Optional<User> getUserByAccountNumber(String accountNumber) {
	    return userRepository.findByAccountNumber(accountNumber);
	}
	
	// Delete user by account number
//	public void deleteUserByAccountNumber(String accountNumber) {
//	    Optional<User> userOpt = userRepository.findByAccountNumber(accountNumber);
//	    if (userOpt.isPresent()) {
//	        userRepository.deleteByAccountNumber(accountNumber);
//	    } else {
//	        throw new RuntimeException("User not found with account number: " + accountNumber);
//	    }
//	}
	
	@Transactional
	public void deleteUserByAccountNumber(String accountNumber) {
	    Optional<User> userOpt = userRepository.findByAccountNumber(accountNumber);
	    if (userOpt.isPresent()) {
	        userRepository.deleteByAccountNumber(accountNumber);
	    } else {
	        throw new RuntimeException("User not found with account number: " + accountNumber);
	    }
	}



}
