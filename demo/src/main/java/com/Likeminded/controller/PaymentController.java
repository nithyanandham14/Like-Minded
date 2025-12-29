package com.likeminded.controller;

import com.likeminded.model.Payment;
import com.likeminded.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    /**
     * VENDOR pays the winner
     */
    @PostMapping("/pay")
    public Payment payWinner(
            Authentication authentication,
            @RequestParam String problemId,
            @RequestParam String winnerUserId,
            @RequestParam Double amount) {

        String vendorId = authentication.getName();
        return paymentService.makePayment(vendorId, problemId, winnerUserId, amount);
    }

    /**
     * USER views received payments
     */
    @GetMapping("/user")
    public List<Payment> getUserPayments(Authentication authentication) {
        return paymentService.getUserPayments(authentication.getName());
    }

    /**
     * VENDOR views payment history
     */
    @GetMapping("/vendor")
    public List<Payment> getVendorPayments(Authentication authentication) {
        return paymentService.getVendorPayments(authentication.getName());
    }
}
