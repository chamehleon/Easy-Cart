package com.ecommerce.Persistence.DAOs.Implementations;

import com.ecommerce.Persistence.DAOs.GenericDAOs.GenericDAOImpl;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Entities.Order;

import com.ecommerce.Persistence.Entities.OrdersItem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderDAO extends GenericDAOImpl<Order> {


    public OrderDAO() {
        super(Order.class);
    }
    /// get all orders by customer
    public Optional<List<Order>> getOrdersByCustomerId(int customerId, EntityManager em) {
        return Optional.ofNullable(em.createQuery("SELECT o FROM Order o WHERE o.customer.id = :customerId", Order.class)
                .setParameter("customerId", customerId)
                .getResultList());
    }
        public Map<Order, List<OrdersItem>> getItemsOfOrders(ArrayList<Order> orders, EntityManager entityManager) {
        Map<Order, List<OrdersItem>> map = new LinkedHashMap<>();
        try {
            for (Order order : orders) {
                order = entityManager.merge(order);
                map.put(order, order.getOrdersItems());
            }

        } catch (NoResultException nre) {
            nre.printStackTrace();
        }
        return (map);
    }


    public Integer getMostRecentOrderPrimaryKeyByCustomer(int customerId, EntityManager em) {
        Query query = em.createQuery(
                "SELECT o.id FROM Order o " +
                        "WHERE o.customer.id = :customerId " +
                        "ORDER BY o.orderedAt DESC", Integer.class);
        query.setParameter("customerId", customerId);
        query.setMaxResults(1);
        return (Integer) query.getSingleResult();
    }
}
