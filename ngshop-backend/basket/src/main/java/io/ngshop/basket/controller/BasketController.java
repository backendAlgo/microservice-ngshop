package io.ngshop.basket.controller;

import io.ngshop.basket.Discount;
import io.ngshop.basket.clients.DiscountClient;
import io.ngshop.basket.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Basket")
public class BasketController {
    @Autowired
    DiscountService discountService;
    @Autowired
    DiscountClient discountClient;
    @GetMapping
    public ResponseEntity<Discount> getDiscount() {
        return ResponseEntity.ok(discountService.getDiscount("64b66e510dc1125b6d8ecb67"));
    }

    @GetMapping("/feign")
    public ResponseEntity<Discount> getDiscountFeign() {
        return ResponseEntity.ok(discountClient.getDiscount("64b66e510dc1125b6d8ecb67"));
    }

    @GetMapping("/working")
    public ResponseEntity<String> getWorking() {
        return ResponseEntity.ok("working");
    }
}
