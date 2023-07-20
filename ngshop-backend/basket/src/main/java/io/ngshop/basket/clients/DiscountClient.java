package io.ngshop.basket.clients;

import io.ngshop.basket.Discount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "discount-service")
public interface DiscountClient {
    @GetMapping("Discount/getProductDiscount/{productId}")
//    @RequestMapping(method = RequestMethod.GET, value = "/getProductDiscount/{productId}")
    Discount getDiscount(@PathVariable String productId);

//    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
//    Post getPostById(@PathVariable("postId") Long postId);
}
