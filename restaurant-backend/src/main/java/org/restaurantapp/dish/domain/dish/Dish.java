package org.restaurantapp.dish.domain.dish;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.dish.domain.recipe.Recipe;
import org.restaurantapp.order.domain.OrderDish;

import java.math.BigDecimal;
import java.util.Set;

@Builder
@Getter
@Entity
@Table(name = "dish")
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @OneToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;
    private BigDecimal price;
    private String calories;
    @ManyToOne
    @JoinColumn(name="category_id")
    private DishCategory dishCategory;
    @OneToMany(mappedBy = "dish")
    private Set<OrderDish> orderDishes;
}
