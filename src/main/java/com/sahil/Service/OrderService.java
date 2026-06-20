package com.sahil.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.Entity.Order;
import com.sahil.Exception.ResourceNotFoundException;
import com.sahil.Repo.OrderRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Order saveOrder(
            Order order) {

        return orderRepo.save(order);
    }

    public List<Order> getAllOrders() {

        return orderRepo.findAll();
    }

    public Order getOrderById(
            Long id) {

        return orderRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order Not Found"));
    }

    public Order updateOrder(
            Long id,
            Order order) {

        Order existingOrder =
                getOrderById(id);

        existingOrder.setStatus(
                order.getStatus());

        existingOrder.setTotalAmount(
                order.getTotalAmount());

        return orderRepo.save(
                existingOrder);
    }

    public void deleteOrder(
            Long id) {

        Order order =
                getOrderById(id);

        orderRepo.delete(order);
    }
}