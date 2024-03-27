package com.ecommerce.Persistence.DAOs.Implementations;

import com.ecommerce.Persistence.DAOs.GenericDAOs.GenericDAOImpl;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Entities.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
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
