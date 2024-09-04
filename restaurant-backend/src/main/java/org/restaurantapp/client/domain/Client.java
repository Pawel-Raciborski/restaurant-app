package org.restaurantapp.client.domain;

import jakarta.persistence.*;
import lombok.*;
import org.restaurantapp.auth.domain.user.User;
import org.restaurantapp.order.domain.OrderSummary;

import java.util.Set;

@Builder
@Getter
@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "client")
    private Set<OrderSummary> orders;
}
