package org.restaurantapp.dish.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@Table(name = "recipe_ingredients")
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Recipe recipe;
    @ManyToOne
    private Ingredient ingredient;
    private Integer quantity;
}
