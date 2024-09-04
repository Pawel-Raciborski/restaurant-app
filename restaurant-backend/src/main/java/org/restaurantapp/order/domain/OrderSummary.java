package org.restaurantapp.order.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.client.domain.Client;
import org.restaurantapp.payment.domain.payment.Payment;

import java.util.Set;

@Builder
@Getter
@Entity
@Table(name = "order_summary")
@NoArgsConstructor
@AllArgsConstructor
public class OrderSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;
    @Column(name = "order_date")
    private String orderDate;
    @Column(name = "realized_order_date")
    private String realizedOrderDate;
    @Column(name = "on_site")
    private Boolean onSite;
    private Boolean paid;
    @OneToOne
    @JoinColumn(name="payment_id")
    private Payment payment;
    @OneToMany(mappedBy = "order")
    private Set<OrderDish> orderDishes;
}
