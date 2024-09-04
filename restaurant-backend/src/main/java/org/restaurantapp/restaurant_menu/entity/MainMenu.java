package org.restaurantapp.restaurant_menu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
