package com.akbank.bms.repository;

import com.akbank.bms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	// Custom finder method
	
	Optional<User> findByEmail(String email);
	
	Optional<User> findByAccountNumber(String accountNumber);
	
	Optional<User> findByPhone(String phone);

	void deleteByAccountNumber(String accountNumber);
	
	
}

// JpaRepository<User, Long>: Gives you all the CRUD methods (save, delete, findById, etc.) automatically.
// JpaRepository<User, Long> I want all the DB methods (save, findAll, deleteById, etc.) for my User entity, whose primary key is of type Long

