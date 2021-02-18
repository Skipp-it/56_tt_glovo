package com.glovo.ttglovo.favourite_meal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteId implements Serializable {

    @Column(name = "user_id")
    @NotNull
    private Long userId;

    @NotNull
    @Column(name = "meal_id")
    private Long mealId;

}
