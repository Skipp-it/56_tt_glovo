package com.glovo.ttglovo.cart;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {

    private Long mealId;
    private Integer quantity;
    private Integer price;

    @Override
    public String toString() {
        return "CartDto{" +
                "mealId=" + mealId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartDto cartDto = (CartDto) o;
        return Objects.equals(mealId, cartDto.mealId) && Objects.equals(quantity, cartDto.quantity) && Objects.equals(price, cartDto.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mealId, quantity, price);
    }
}
