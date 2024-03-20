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

    public Cart getCartByCustomer(Customer customer, EntityManager entityManager) {
        try {
            System.out.println("d5l try wala la2");
            TypedQuery<Cart> query = entityManager.createQuery("SELECT c FROM Cart c WHERE c.customer = :customer", Cart.class);
            query.setParameter("customer", customer);
            System.out.println("query "+query.getSingleResult().toString());
            System.out.println("aaaaaaaeeeeeeeee "+customer.getEmail());
            return query.getSingleResult();
        } catch (NoResultException nre) {
            Cart newCart = new Cart();
            //customer.setId(7);
            System.out.println("from view cart: "+customer.toString());
            newCart.setCustomer(customer);

            create(newCart, entityManager);
            //nre.printStackTrace();
            return newCart;
        }
    }

    public Set<CartItem> getAllCartItems(Customer customer, EntityManager entityManager) {
        System.out.println("zzzz");
        Cart retrievedCart = getCartByCustomer(customer, entityManager);
        if (retrievedCart != null) {
            System.out.println("retrievedCart: " + retrievedCart.toString());
            System.out.println("entity manager check "+entityManager.contains(retrievedCart));
            TypedQuery<CartItem> query = entityManager.createQuery("SELECT ci FROM CartItem ci WHERE ci.cart = :cart", CartItem.class);
            query.setParameter("cart", retrievedCart);
            List<CartItem> resultList = query.getResultList();
            System.out.println("retrieved Cart query: " + resultList);

            Set<CartItem> sortedCartItems = resultList.stream()
                    .sorted(Comparator.comparing(item -> item.getProduct().getProductPrice().multiply(BigDecimal.valueOf(item.getQuantity()))))
                    .collect(Collectors.toCollection(LinkedHashSet::new));

            return sortedCartItems;

           // return new HashSet<>(resultList);
        } else {
            return Collections.emptySet();
        }
    }


}
