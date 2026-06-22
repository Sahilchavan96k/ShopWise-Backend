package com.sahil.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sahil.Entity.Cart;
import com.sahil.Entity.Order;
import com.sahil.Entity.OrderItem;
import com.sahil.Entity.User;
import com.sahil.Exception.ResourceNotFoundException;
import com.sahil.Repo.CartRepo;
import com.sahil.Repo.OrderItemRepo;
import com.sahil.Repo.OrderRepo;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderItemRepo orderItemRepo;

    public Cart addToCart(
            Cart cart) {

        return cartRepo.save(cart);
    }

    public List<Cart> getCartByUser(
            Long userId) {

        return cartRepo.findByUserId(
                userId);
    }

    public void removeFromCart(
            Long id) {

        Cart cart =
                cartRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cart Item Not Found"));

        cartRepo.delete(cart);
    }

    public List<Cart> getAllCart() {

        return cartRepo.findAll();
    }

    public Cart updateQuantity(
            Long id,
            Integer quantity) {

        Cart cart =
                cartRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Cart Item Not Found"));

        cart.setQuantity(
                quantity);

        return cartRepo.save(
                cart);
    }

    public Order checkout(
            Long userId) {

        List<Cart> cartItems =
                cartRepo.findByUserId(
                        userId);

        if (cartItems.isEmpty()) {

            throw new RuntimeException(
                    "Cart Is Empty");
        }

        User user =
                cartItems.get(0)
                        .getUser();

        double totalAmount = 0;

        for (Cart cart : cartItems) {

            totalAmount +=
                    cart.getProduct()
                            .getPrice()
                            *
                            cart.getQuantity();
        }

        Order order =
                new Order();

        order.setUser(
                user);

        order.setStatus(
                "PENDING");

        order.setTotalAmount(
                totalAmount);

        Order savedOrder =
                orderRepo.save(
                        order);

        List<OrderItem> orderItems =
                new ArrayList<>();

        for (Cart cart : cartItems) {

            OrderItem orderItem =
                    new OrderItem();

            orderItem.setOrder(
                    savedOrder);

            orderItem.setProduct(
                    cart.getProduct());

            orderItem.setQuantity(
                    cart.getQuantity());

            orderItem.setPrice(
                    cart.getProduct()
                            .getPrice());

            orderItemRepo.save(
                    orderItem);

            orderItems.add(
                    orderItem);
        }
        
        savedOrder.setOrderItems(
                orderItems);

        orderRepo.save(
                savedOrder);

        cartRepo.deleteAll(
                cartItems);

        return savedOrder;
    }
}