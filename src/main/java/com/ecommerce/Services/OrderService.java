package com.ecommerce.Services;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Persistence.DAOs.Implementations.OrderDAO;
import com.ecommerce.Persistence.DAOs.Implementations.OrderItemDAO;
import com.ecommerce.Persistence.Entities.Order;
import com.ecommerce.Persistence.Entities.OrdersItem;
import com.ecommerce.Utils.JpaTransactionManager;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderService {

    // get orders by customer function
    public static Optional<List<Order>> getOrdersByCustomerId(int customerId) {
        return JpaTransactionManager.doInTransaction(em -> {
            OrderDAO orderDAO = new OrderDAO();
            return orderDAO.getOrdersByCustomerId(customerId, em);
        });
    }
    public static Order getOrderById(int orderId) {
        return JpaTransactionManager.doInTransaction(em -> {
            OrderDAO orderDAO = new OrderDAO();
            return orderDAO.findById(orderId, em);
        });
    }

    public static BigDecimal getOrderTotal(int orderId) {
        return JpaTransactionManager.doInTransaction(em -> {
            OrderItemDAO orderItemDAO = new OrderItemDAO();
            return orderItemDAO.getOrderItemsTotalByOrderId(orderId, em).orElse(new BigDecimal(0.0));
        });
    }
        public static Map<Order, List<OrdersItem>> getAllOrderItems(ArrayList<Order> orders) {
        Map<Order, List<OrdersItem>> ordersWithItems;
        OrderDAO orderDAO = new OrderDAO();
        ordersWithItems = (Map<Order, List<OrdersItem>>) JpaTransactionManager.doInTransaction(em -> orderDAO.getItemsOfOrders(orders, em));
        return ordersWithItems;
    }



}
