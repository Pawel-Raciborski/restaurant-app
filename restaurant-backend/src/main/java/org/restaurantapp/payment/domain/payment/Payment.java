package org.restaurantapp.payment.domain.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.restaurantapp.order.domain.OrderSummary;
import org.restaurantapp.payment.domain.currency.Currency;

import java.math.BigDecimal;

@Builder
@Getter
@Entity
@Table(name = "payment")
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;
    @ManyToOne
    @JoinColumn(name="payment_method_id")
    private PaymentMethod paymentMethod;
    @OneToOne(mappedBy = "payment")
    private OrderSummary orderSummary;
}
