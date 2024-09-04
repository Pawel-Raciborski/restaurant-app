package org.restaurantapp.dish.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.magazine.entity.MagazineIngredient;

import java.util.Set;

@Builder
@Getter
@Entity
@Table(name = "ingredient")
@NoArgsConstructor
@AllArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String category;
    
    @OneToMany(mappedBy = "ingredient")
    private Set<MagazineIngredient> magazineIngredients;
}
