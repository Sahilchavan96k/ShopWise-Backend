package com.sahil.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sahil.Entity.Cart;
import com.sahil.Entity.Order;
import com.sahil.Service.CartService;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public Cart addToCart(
            @RequestBody Cart cart) {

        return cartService
                .addToCart(cart);
    }

    @GetMapping
    public List<Cart> getAllCart() {

        return cartService
                .getAllCart();
    }

    @GetMapping("/user/{userId}")
    public List<Cart> getCartByUser(
            @PathVariable Long userId) {

        return cartService
                .getCartByUser(
                        userId);
    }

    @PutMapping("/{id}")
    public Cart updateQuantity(
            @PathVariable Long id,
            @RequestParam Integer quantity) {

        return cartService
                .updateQuantity(
                        id,
                        quantity);
    }

    @DeleteMapping("/{id}")
    public String removeFromCart(
            @PathVariable Long id) {

        cartService.removeFromCart(
                id);

        return "Item Removed From Cart";
    }

    @PostMapping("/checkout/{userId}")
    public Order checkout(
            @PathVariable Long userId) {

        return cartService
                .checkout(userId);
    }
}	