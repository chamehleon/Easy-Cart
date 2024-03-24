package com.ecommerce.Persistence.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cart", schema = "ecommerce")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "cart" ,fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    private Set<CartItem> cartItems = new LinkedHashSet<>();

    public void addCartItem(Product product , Integer quantity , BigDecimal amount){
        cartItems.add(new CartItem(this, product, quantity, amount));
    }

    public void removeCartItem(CartItem cartItem) {
        cartItems.remove(cartItem);
    }
}