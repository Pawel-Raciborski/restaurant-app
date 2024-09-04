package org.restaurantapp.payment.domain.currency;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.payment.domain.payment.Payment;

import java.util.Set;

@Builder
@Getter
@Entity
@Table(name = "currency")
@NoArgsConstructor
@AllArgsConstructor
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "currency")
    private Set<Payment> payments;
}
