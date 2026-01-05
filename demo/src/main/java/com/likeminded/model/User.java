package com.likeminded.model;

import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String college;

    private String role;
    @Column(nullable = false)
    private String password;
}
