package ru.ivanovds.april.market.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.ivanovds.april.market.dtos.CartDto;
import ru.ivanovds.april.market.utils.Cart;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
@Slf4j
public class CartController {
    private final Cart cart;

    @GetMapping("/add/{productId}")
    public void addToCart(@PathVariable(name = "productId") Long id) {
        cart.addToCart(id);
    }

    @DeleteMapping("/add/{productId}")
    public void delToCart(@PathVariable(name = "productId") Long id) {
        cart.delToCart(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cart.clear();
    }

    @GetMapping
    public CartDto getCart() {
        return new CartDto(cart);
    }
}
