package org.restaurantapp.restaurant_menu.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.worker.entity.Worker;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

@Builder
@Getter
@Entity
@Table(name = "time_of_day_menu")
@NoArgsConstructor
@AllArgsConstructor
public class TimeOfDayMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "time_of_day_name")
    private String timeOfDayName;
    private String description;
    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker workerUpdated;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "end_time")
    private LocalTime endTime;
    @OneToMany(mappedBy = "timeOfDayMenu")
    private Set<TimeOfDayMenuCategory> menuCategories;
    @OneToOne(mappedBy = "timeOfDayMenu")
    private MainMenu mainMenu;
}
