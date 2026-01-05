package com.likeminded.repository;

import com.likeminded.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    boolean existsByProblemId(String problemId);

    List<Payment> findByWinnerUserId(String userId);

    List<Payment> findByVendorId(String vendorId);
}
