package org.restaurantapp.dish.domain.recipe;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.dish.domain.ingredient.Ingredient;
import org.restaurantapp.magazine.domain.unit.Unit;

@Builder
@Getter
@Entity
@Table(name = "recipe_ingredient")
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
    @ManyToOne
    @JoinColumn(name="ingredient_id")
    private Ingredient ingredient;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name="unit_id")
    private Unit unit;
}
