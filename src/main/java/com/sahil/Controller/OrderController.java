package com.sahil.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sahil.Entity.Order;
import com.sahil.Service.OrderService;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order addOrder(
            @RequestBody Order order) {

        return orderService.saveOrder(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {

        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(
            @PathVariable Long id) {

        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Order updateOrder(
            @PathVariable Long id,
            @RequestBody Order order) {

        return orderService.updateOrder(
                id,
                order);
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(
            @PathVariable Long id) {

        orderService.deleteOrder(id);

        return "Order Deleted Successfully";
    }
}