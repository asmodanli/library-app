package com.sign.demo.service;

import com.sign.demo.dto.UserRegistrationDto;
import com.sign.demo.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByEmail(String email);

    User save(UserRegistrationDto registration);
}