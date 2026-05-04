package com.likeminded.controller;

import com.likeminded.dto.UserDashboardResponse;
import com.likeminded.dto.UserRegisterRequest;
import com.likeminded.dto.UserResponse;
import com.likeminded.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponse register(@RequestBody UserRegisterRequest request) {
        return userService.registerUser(request);
    }
    @GetMapping("/dashboard")
    public UserDashboardResponse getDashboard(Authentication authentication) {

        String userId = authentication.name();

        return userService.getDashboard(userId);
    }
}
