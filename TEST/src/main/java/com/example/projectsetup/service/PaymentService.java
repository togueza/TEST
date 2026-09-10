package com.example.projectsetup.service;

import com.example.projectsetup.model.Payment;
import com.example.projectsetup.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment registerPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public String verifyPayment(Long id) {
        return paymentRepository.findById(id)
                .map(Payment::getStatus)
                .orElse("Not found");
    }

    public Payment changePaymentStatus(Long id, String status) {
        return paymentRepository.findById(id)
                .map(payment -> {
                    payment.setStatus(status);
                    return paymentRepository.save(payment);
                })
                .orElse(null);
    }
}
