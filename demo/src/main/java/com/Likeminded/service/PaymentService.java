package com.likeminded.service;

import com.likeminded.model.Payment;
import com.likeminded.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    /**
     * Vendor pays the winner after selection
     */
    public Payment makePayment(
            String vendorId,
            String problemId,
            String winnerUserId,
            Double amount) {

        // Ensure payment happens only once per problem
        if (paymentRepository.existsByProblemId(problemId)) {
            throw new RuntimeException("Payment already completed for this problem");
        }

        Payment payment = Payment.builder()
                .vendorId(vendorId)
                .problemId(problemId)
                .winnerUserId(winnerUserId)
                .amount(amount)
                .build();

        return paymentRepository.save(payment);
    }

    /**
     * Winner views received payments
     */
    public java.util.List<Payment> getUserPayments(String userId) {
        return paymentRepository.findByWinnerUserId(userId);
    }

    /**
     * Vendor views payment history
     */
    public java.util.List<Payment> getVendorPayments(String vendorId) {
        return paymentRepository.findByVendorId(vendorId);
    }
}
