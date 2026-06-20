package com.sahil.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sahil.Entity.Payment;
import com.sahil.Service.PaymentService;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin("*")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public Payment addPayment(
            @RequestBody Payment payment) {

        return paymentService.savePayment(payment);
    }

    @GetMapping
    public List<Payment> getAllPayments() {

        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(
            @PathVariable Long id) {

        return paymentService.getPaymentById(id);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(
            @PathVariable Long id,
            @RequestBody Payment payment) {

        return paymentService.updatePayment(
                id,
                payment);
    }

    @DeleteMapping("/{id}")
    public String deletePayment(
            @PathVariable Long id) {

        paymentService.deletePayment(id);

        return "Payment Deleted Successfully";
    }

}