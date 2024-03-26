package com.ecommerce.Persistence.DAOs.Implementations;

import com.ecommerce.Persistence.DAOs.GenericDAOs.GenericDAOImpl;
import com.ecommerce.Persistence.Entities.Cart;
import com.ecommerce.Persistence.Entities.CartItem;
import com.ecommerce.Persistence.Entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class CartDAO extends GenericDAOImpl<Cart> {
    public CartDAO() {
        super(Cart.class);
    }

   //get cart by customer
    public Cart getCartByCustomer(Customer customer, EntityManager entityManager) {
        TypedQuery<Cart> query = entityManager.createQuery("SELECT c FROM Cart c WHERE c.customer = :customer", Cart.class);
        query.setParameter("customer", customer);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }



    //get all cart items for a customer
    public Set<CartItem> getCartItemsByCustomer(Customer customer, EntityManager entityManager) {
        Cart cart = getCartByCustomer(customer, entityManager);
        if (cart == null) {
            return new HashSet<>();
        }
        return cart.getCartItems();
    }



}
