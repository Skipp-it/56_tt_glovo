package com.glovo.ttglovo.cart;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private Long mealId;
    private Integer quantity;
    private Integer price;


}
