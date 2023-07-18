package io.ngshop.basket.clients;

import io.ngshop.basket.Discount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(url = "http://localhost:8085/Discount", value = "discount")
@Component
public interface DiscountClient {
    @RequestMapping(method = RequestMethod.GET, value = "/getProductDiscount/{productId}")
    Discount getDiscount(@PathVariable String productId);

//    @RequestMapping(method = RequestMethod.GET, value = "/posts/{postId}", produces = "application/json")
//    Post getPostById(@PathVariable("postId") Long postId);
}
