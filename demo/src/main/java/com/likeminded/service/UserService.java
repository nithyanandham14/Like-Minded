package com.likeminded.service;

import com.likeminded.dto.UserRegisterRequest;
import com.likeminded.dto.UserResponse;
import com.likeminded.model.User;
import com.likeminded.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse registerUser(UserRegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered");
        }

        if (request.getPassword() == null || request.getPassword().isBlank()) {
            throw new RuntimeException("Password cannot be null or empty");
        }

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .college(request.getCollege())
                .password(passwordEncoder.encode(request.getPassword())) // ✅ FIX
                .role("USER")
                .build();

        User saved = userRepository.save(user);

        return UserResponse.builder()
                .id(saved.getId())
                .name(saved.getName())
                .email(saved.getEmail())
                .college(saved.getCollege())
                .build();
    }
}
