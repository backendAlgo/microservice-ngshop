package io.ngshop.discount.controller;

import io.ngshop.discount.Discount;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Discount")
public class DiscountController {
    Map<String, Discount> productToDiscount =
            Map.of(
                    "602d2149e773f2a3990b47f5", new Discount(1L),
                    "64b29bf80634786c559d8c13", new Discount(2L),
                    "64b29c340634786c559d8c14", new Discount(2L),
                    "64b66e3f0dc1125b6d8ecb66", new Discount(2L),
                    "64b66e510dc1125b6d8ecb67", new Discount(3L),
                    "64b66e550dc1125b6d8ecb68", new Discount(4L),
                    "64b66e580dc1125b6d8ecb69", new Discount(5L)
            );

    @GetMapping("/getProductDiscount/{productId}")
    public ResponseEntity<Discount> getDiscount(@PathVariable String productId) {
        return ResponseEntity.ok(productToDiscount.get(productId));

//        select discount_id from discount_product
//        join discount on discount_product.discount_id = discount.id
//                where discount_product.productId = productId;
//        order by created_at
//                limit 1
    }
}
