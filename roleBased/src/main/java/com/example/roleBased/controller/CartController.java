package com.example.roleBased.controller;

import com.example.roleBased.entity.CartDetails;
import com.example.roleBased.serviceImpl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

    @Autowired
    private CartServiceImpl cartservice;


    @PreAuthorize("hasRole('User')")
    @GetMapping({"/addToCart/{productId}"})
    public CartDetails addToCart(@PathVariable(name = "productId") Integer productId)
    {
        return cartservice.addToCart(productId);
    }

}
