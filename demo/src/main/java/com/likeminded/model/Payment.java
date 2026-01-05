package com.likeminded.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String problemId;

    @Column(nullable = false)
    private String vendorId;

    @Column(nullable = false)
    private String winnerUserId;

    @Column(nullable = false)
    private Double amount;

    private LocalDateTime paidAt;

    @PrePersist
    void onPay() {
        this.paidAt = LocalDateTime.now();
    }
}
