package org.restaurantapp.restaurant_menu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.dish.entity.Dish;

@Builder
@Getter
@Entity
@Table(name = "time_of_day_dish")
@NoArgsConstructor
@AllArgsConstructor
public class TimeOfDayDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="time_of_day_menu_category_id")
    private TimeOfDayMenuCategory timeOfDayMenuCategory;
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dish dish;
}
