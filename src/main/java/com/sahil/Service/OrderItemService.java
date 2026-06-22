package com.sahil.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.Entity.OrderItem;
import com.sahil.Repo.OrderItemRepo;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepo;

    public OrderItem saveOrderItem(
            OrderItem orderItem) {

        return orderItemRepo.save(
                orderItem);
    }

    public List<OrderItem> getOrderItemsByOrder(
            Long orderId) {

        return orderItemRepo.findByOrderId(
                orderId);
    }
}