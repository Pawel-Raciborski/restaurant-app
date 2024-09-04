package org.restaurantapp.restaurant_menu.domain.time_of_day_menu;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Builder
@Getter
@Entity
@Table(name = "time_of_day_menu_category")
@NoArgsConstructor
@AllArgsConstructor
public class TimeOfDayMenuCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "category_name")
    private String categoryName;
    private String description;
    @ManyToOne
    @JoinColumn(name="time_of_day_menu_id")
    private TimeOfDayMenu timeOfDayMenu;
    @OneToMany(mappedBy = "timeOfDayMenuCategory")
    private Set<TimeOfDayDish> timeOfDayDishes;
}
