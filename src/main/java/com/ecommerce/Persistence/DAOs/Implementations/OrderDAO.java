package com.ecommerce.Persistence.DAOs.Implementations;

import com.ecommerce.Persistence.DAOs.GenericDAOs.GenericDAOImpl;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Entities.Order;

public class OrderDAO extends GenericDAOImpl<Order> {
    public OrderDAO() {
        super(Order.class);
    }

}
