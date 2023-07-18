package io.ngshop.discount;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Discount {
    private Long id;
    private String description;
    private Long amount;

    public Discount(Long id) {
        this.id = id;
    }
}
