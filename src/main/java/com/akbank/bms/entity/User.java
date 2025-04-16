package com.akbank.bms.entity;

import jakarta.persistence.*;
//import java.util.Random;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "account_number", unique = true)
	private String accountNumber;
	
	@Column(name = "full_name",nullable = false)
	private String fullName;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "phone", nullable = false, length = 10)
	private String phone;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "balance")
    private Double balance;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	// Phone Number Validation Logic
    public void setPhone(String phone) {
        phone = phone.replaceAll("\\D", ""); // remove all non-digit chars
        phone = phone.replaceFirst("^0+(?!$)", ""); // remove leading zeros

        if (phone.length() != 10) {
            throw new IllegalArgumentException("Phone number must be exactly 10 digits after trimming leading zeros.");
        }

        this.phone = phone;
    }

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
}
