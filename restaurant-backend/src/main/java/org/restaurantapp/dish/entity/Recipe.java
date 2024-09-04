package org.restaurantapp.dish.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.Set;

@Builder
@Getter
@Entity
@Table(name = "recipe")
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private Duration prepareTime;
    @OneToOne(mappedBy = "recipe")
    private Dish dish;
    @OneToMany(mappedBy = "recipe")
    private Set<RecipeIngredient> recipeIngredients;
}
