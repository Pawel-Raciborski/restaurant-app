package org.restaurantapp.magazine.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.dish.entity.Ingredient;

import java.util.Set;

@Builder
@Getter
@Entity
@Table(name = "magazine")
@NoArgsConstructor
@AllArgsConstructor
public class Magazine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "magazine")
    private Set<MagazineIngredient> magazineIngredients;
}
