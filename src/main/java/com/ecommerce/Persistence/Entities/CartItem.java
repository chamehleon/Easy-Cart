package com.ecommerce.Persistence.Entities;

import com.google.gson.annotations.SerializedName;
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
@Table(name = "cart_item", schema = "ecommerce")
public class CartItem {
    @EmbeddedId
    private CartItemId id;

    @MapsId("cartId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    @MapsId("productId")
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    public CartItem(Cart cart, Product product, Integer quantity, BigDecimal amount) {
        this.cart = cart;
        this.product = product;
        this.quantity = quantity;
        this.amount = amount;
        this.id = new CartItemId(cart.getId(), product.getId());
    }

}