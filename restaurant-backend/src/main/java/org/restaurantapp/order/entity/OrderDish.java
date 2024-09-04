package org.restaurantapp.order.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.dish.entity.Dish;

@Builder
@Getter
@Entity
@Table(name = "order_dish")
@NoArgsConstructor
@AllArgsConstructor
public class OrderDish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name="dish_id")
    private Dish dish;
    @ManyToOne
    @JoinColumn(name="order_id")
    private OrderSummary order;
    private Integer quantity;
}
