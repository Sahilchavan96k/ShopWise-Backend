package com.sahil.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.Entity.Payment;

public interface PaymentRepo
        extends JpaRepository<Payment, Long> {

}