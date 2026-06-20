package com.sahil.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.Entity.Order;

public interface OrderRepo
        extends JpaRepository<Order, Long> {

}