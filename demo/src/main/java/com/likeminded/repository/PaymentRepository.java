package com.likeminded.repository;

import com.likeminded.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, String> {

    boolean existsByProblemId(String problemId);

    List<Payment> findByWinnerUserId(String userId);

    List<Payment> findByVendorId(String vendorId);

    @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.vendorId = :vendorId")
    Double sumAmountByVendorId(@Param("vendorId") String vendorId);

    @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.winnerUserId = :userId")
    Double sumAmountByWinnerUserId(@Param("userId") String userId);
}