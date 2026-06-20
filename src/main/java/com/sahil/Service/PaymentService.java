package com.sahil.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.Entity.Payment;
import com.sahil.Exception.ResourceNotFoundException;
import com.sahil.Repo.PaymentRepo;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public Payment savePayment(
            Payment payment) {

        return paymentRepo.save(payment);
    }

    public List<Payment> getAllPayments() {

        return paymentRepo.findAll();
    }

    public Payment getPaymentById(
            Long id) {

        return paymentRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Payment Not Found"));
    }

    public Payment updatePayment(
            Long id,
            Payment payment) {

        Payment existingPayment =
                getPaymentById(id);

        existingPayment.setAmount(
                payment.getAmount());

        existingPayment.setPaymentMethod(
                payment.getPaymentMethod());

        existingPayment.setPaymentStatus(
                payment.getPaymentStatus());

        existingPayment.setOrder(
                payment.getOrder());

        return paymentRepo.save(
                existingPayment);
    }

    public void deletePayment(
            Long id) {

        Payment payment =
                getPaymentById(id);

        paymentRepo.delete(payment);
    }

}