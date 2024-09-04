package org.restaurantapp.magazine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.dish.entity.Ingredient;

@Builder
@Getter
@Entity
@Table(name = "magazine_ingredient")
@NoArgsConstructor
@AllArgsConstructor
public class MagazineIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="magazine_id")
    private Magazine magazine;
    @ManyToOne
    @JoinColumn(name="ingredient_id")
    private Ingredient ingredient;
    private String quantity;
    @ManyToOne
    @JoinColumn(name="unit_id")
    private Unit unit;
}
