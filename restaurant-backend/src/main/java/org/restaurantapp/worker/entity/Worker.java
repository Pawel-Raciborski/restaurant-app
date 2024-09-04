package org.restaurantapp.client.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@Entity
@Table(name = "worker")
@NoArgsConstructor
@AllArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String pesel;
    private String name;
    private String surname;
    private String password;
    private String email;
    @Column(name = "date_of_employment")
    private String dateOfEmployment;

    @ManyToMany
    @JoinTable(
            name = "worker_order"
    )
}
