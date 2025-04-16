package com.akbank.bms.util;

import com.akbank.bms.dto.UserDTO;
import com.akbank.bms.entity.User;

public class UserMapper {
    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setPhone(dto.getPhone());
        user.setPassword(dto.getPassword());
        user.setBalance(dto.getBalance());
        return user;
    }
}
