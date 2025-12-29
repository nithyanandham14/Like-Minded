package com.likeminded.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String teamName;

    @Column(nullable = false)
    private String leaderUserId;
}
