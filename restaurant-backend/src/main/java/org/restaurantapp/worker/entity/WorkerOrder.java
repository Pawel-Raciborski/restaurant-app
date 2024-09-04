package org.restaurantapp.worker.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.order.entity.OrderSummary;

@Builder
@Getter
@Entity
@Table(name = "worker_order")
@NoArgsConstructor
@AllArgsConstructor
public class WorkerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderSummary order;
}
