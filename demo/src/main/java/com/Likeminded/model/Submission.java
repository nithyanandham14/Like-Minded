package com.likeminded.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "submissions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String problemId;

    @Column(nullable = false)
    private String teamId;

    @Column(nullable = false)
    private String submittedByUserId;

    @Column(nullable = false)
    private String fileUrl;   // PDF / GitHub / Drive link

    private LocalDateTime submittedAt;

    @PrePersist
    void onSubmit() {
        this.submittedAt = LocalDateTime.now();
    }
}
