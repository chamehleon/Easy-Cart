package com.ecommerce.Persistence.DAOs.Implementations;

import com.ecommerce.Persistence.DAOs.GenericDAOs.GenericDAOImpl;
import com.ecommerce.Persistence.Entities.OrdersItem;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.Optional;

public class OrderItemDAO extends GenericDAOImpl<OrdersItem> {

    public OrderItemDAO() {
        super(OrdersItem.class);
    }

    public Optional<BigDecimal> getOrderItemsTotalByOrderId(int orderId, EntityManager em) {
        return Optional.ofNullable(em.createQuery("SELECT SUM(oi.quantity * oi.amount) FROM OrdersItem oi WHERE oi.order.id = :orderId", BigDecimal.class)
                .setParameter("orderId", orderId)
                .getSingleResult());
    }
}
