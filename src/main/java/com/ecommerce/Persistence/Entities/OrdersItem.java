package com.ecommerce.Persistence.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders_items", schema = "ecommerce")
public class OrdersItem {
    @EmbeddedId
    private OrdersItemId id;

    @MapsId("orderId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @MapsId("productId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    public OrdersItem(Order order, Product product, Integer quantity, BigDecimal amount) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
        this.id = new OrdersItemId(order.getId(), product.getId());
    }

}