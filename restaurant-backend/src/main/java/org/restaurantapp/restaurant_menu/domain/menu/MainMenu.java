package org.restaurantapp.restaurant_menu.domain.menu;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.restaurant_menu.domain.time_of_day_menu.TimeOfDayMenu;

@Builder
@Getter
@Entity
@Table(name = "main_menu")
@NoArgsConstructor
@AllArgsConstructor
public class MainMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "sub_menu_id")
    private TimeOfDayMenu timeOfDayMenu;
}
