package io.ngshop.basket.service;

import io.ngshop.basket.Discount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DiscountService {

    public static final String DISCOUNT_BASE_URL = "http://localhost:8085/Discount";

    public Discount getDiscount(String productId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Discount> discountResponseEntity = restTemplate
                .getForEntity(DISCOUNT_BASE_URL + "/getProductDiscount/64b29bf80634786c559d8c13",
                        Discount.class);
        log.info("returned response: {}", discountResponseEntity);
        return discountResponseEntity.getBody();
//        restTemplate => OpenFeign
//        jdbcTemplate => Spring data JPA
    }
}
