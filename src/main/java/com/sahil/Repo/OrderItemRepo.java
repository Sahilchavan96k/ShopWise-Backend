package com.sahil.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.Entity.OrderItem;

public interface OrderItemRepo
        extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrderId(
            Long orderId);

}