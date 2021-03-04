package com.glovo.ttglovo.recipe;

import com.glovo.ttglovo.securityManagement.appuser.AppUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name="RecipeModel")
@Table(name="recipe")
public class RecipeItem {

    @Id
    @SequenceGenerator(
            name = "recipe_sequence",
            sequenceName = "recipe_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "recipe_sequence"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "name", columnDefinition = "text", length=10485760)
    private String name;

    @Column(name="description", columnDefinition = "text", length=10485760)
    private String description;

    @Column(name="image")
   private String image;
    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "user_id_fk"
            )
    )
    private AppUser user;




    @Override
    public String toString() {
        return "RecipeItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                '}';
    }
}
