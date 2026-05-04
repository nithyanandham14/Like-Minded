package com.likeminded.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "selections")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Selection {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String problemId;

    @Column(nullable = false)
    private String submissionId;

    @Column(nullable = false)
    private String vendorId;

    private LocalDateTime selectedAt;

    @PrePersist
    void onSelect() {
        this.selectedAt = LocalDateTime.now();
    }
    @Column(nullable = false)
    private String winnerUserId;
}
