package com.example.projectsetup.controller;

import com.example.projectsetup.model.Payment;
import com.example.projectsetup.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@Tag(name = "Payments", description = "Endpoints for registering and updating payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    @Operation(summary = "Register a payment", description = "Creates a new payment record.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Payment registered",
                    content = @Content(schema = @Schema(implementation = Payment.class)))
    })
    public ResponseEntity<Payment> registerPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.registerPayment(payment));
    }

    @GetMapping("/{id}/status")
    @Operation(summary = "Get payment status", description = "Returns the current status for a payment id.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Payment status returned")
    })
    public ResponseEntity<String> verifyPayment(@PathVariable Long id) {
        return ResponseEntity.ok(paymentService.verifyPayment(id));
    }

    @PutMapping("/{id}/status")
    @Operation(summary = "Update payment status", description = "Changes the status of an existing payment.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Payment status updated",
                    content = @Content(schema = @Schema(implementation = Payment.class)))
    })
    public ResponseEntity<Payment> changePaymentStatus(
            @Parameter(description = "Payment identifier") @PathVariable Long id,
            @Parameter(description = "New payment status") @RequestParam String status) {
        return ResponseEntity.ok(paymentService.changePaymentStatus(id, status));
    }
}
