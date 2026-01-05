package com.likeminded.repository;

import com.likeminded.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    // Check if email already exists (used in register)
    boolean existsByEmail(String email);

    // Fetch user by email (used in login & JWT)
    Optional<User> findByEmail(String email);
}
