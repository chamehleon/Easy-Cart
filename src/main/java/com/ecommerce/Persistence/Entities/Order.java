package com.ecommerce.Persistence.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders", schema = "ecommerce")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "ordered_at", nullable = false)
    private Instant orderedAt;

    @OneToMany(mappedBy = "order" ,fetch = FetchType.EAGER )
    private Set<OrdersItem> orderItems = new LinkedHashSet<>();

    public void addOrderItem(Product product , Integer quantity , BigDecimal amount){
        orderItems.add(new OrdersItem(this, product, quantity, amount));
    }
    @OneToMany(mappedBy = "order",fetch = FetchType.EAGER)
    List<OrdersItem> ordersItems ;
}