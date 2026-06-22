package com.sahil.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sahil.Entity.OrderItem;
import com.sahil.Service.OrderItemService;

@RestController
@RequestMapping("/api/order-items")
@CrossOrigin("*")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public OrderItem saveOrderItem(
            @RequestBody OrderItem orderItem) {

        return orderItemService
                .saveOrderItem(
                        orderItem);
    }

    @GetMapping("/order/{orderId}")
    public List<OrderItem> getOrderItems(
            @PathVariable Long orderId) {

        return orderItemService
                .getOrderItemsByOrder(
                        orderId);
    }
}	