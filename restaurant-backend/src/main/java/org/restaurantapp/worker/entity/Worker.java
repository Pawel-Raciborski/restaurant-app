package org.restaurantapp.worker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.restaurant_menu.entity.TimeOfDayMenu;

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
    private String name;
    private String surname;
    private String password;
    private String email;
    @Column(name = "date_of_employment")
    private LocalDateTime dateOfEmployment;

    @OneToMany(mappedBy = "workerUpdated")
    private Set<TimeOfDayMenu> updatedMenus;
    
    @OneToMany(mappedBy = "worker")
    private Set<WorkerOrder> workerOrders;
}
