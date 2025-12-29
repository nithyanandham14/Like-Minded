package com.likeminded.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "team_members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String teamId;

    @Column(nullable = false)
    private String userId;
}
