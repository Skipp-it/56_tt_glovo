package com.glovo.ttglovo.recipe;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class RecipeDTO {

    private Long id;
    private String name;
    private String description;
    private String userFirstName;
    private Long userId;
    private String image;


    @Override
    public String toString() {
        return "RecipeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
