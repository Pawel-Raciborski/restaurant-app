package org.restaurantapp.worker.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.auth.domain.user.User;
import org.restaurantapp.restaurant_menu.domain.time_of_day_menu.TimeOfDayMenu;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Builder
@Getter
@Entity
@Table(name = "worker")
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String pesel;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "hourly_rate")
    private BigDecimal hourlyRate;

    @Column(name = "date_of_employment")
    private LocalDateTime dateOfEmployment;

    @OneToMany(mappedBy = "workerUpdated")
    private Set<TimeOfDayMenu> updatedMenus;

    @OneToMany(mappedBy = "worker")
    private Set<WorkerOrder> workerOrders;
}
