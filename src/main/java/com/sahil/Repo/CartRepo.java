package com.sahil.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.Entity.Cart;

public interface CartRepo
        extends JpaRepository<Cart, Long> {

    List<Cart> findByUserId(
            Long userId);
}