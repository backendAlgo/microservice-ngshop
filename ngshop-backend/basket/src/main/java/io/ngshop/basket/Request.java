package io.ngshop.basket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Request implements Serializable {
        public String UserName;
        public Double TotalPrice;
}
