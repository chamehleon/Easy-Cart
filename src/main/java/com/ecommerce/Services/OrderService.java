package com.ecommerce.Services;

import com.ecommerce.Persistence.DAOs.Implementations.OrderDAO;
import com.ecommerce.Persistence.Entities.CartItem;
import com.ecommerce.Persistence.Entities.Order;
import com.ecommerce.Persistence.Entities.OrdersItem;
import com.ecommerce.Utils.JpaTransactionManager;

import java.util.List;

public class OrderService {

    public static boolean createOrderFromCartItems(List<CartItem> cartItems) {
        return JpaTransactionManager.doInTransaction(em -> {
            OrderDAO orderDAO = new OrderDAO();
            Order order = new Order();
            System.out.println("OrderService.createOrderFromCartItems");
            // Convert CartItems to OrderItems and add them to the Order
            for (CartItem cartItem : cartItems) {
                OrdersItem orderItem = new OrdersItem();
                orderItem.setProduct(cartItem.getProduct());
                orderItem.setQuantity(cartItem.getQuantity());
                orderItem.setAmount(cartItem.getAmount());
                orderItem.setOrder(order);
                order.getOrderItems().add(orderItem);
                System.out.println(orderItem.toString());
            }
            System.out.println(order);
            boolean orderCreated = orderDAO.create(order, em);

            if (orderCreated) {
                System.out.println("gowa el if condition orderCreated");
                CartService.clearCart(cartItems);
                return true;
            } else {
                return false;
            }
        });
    }






    /*
    * JpaTransactionManager.doInTransaction(em -> {
            OrderDAO orderDAO = new OrderDAO();
            Order order = new Order();
            order.setOrderDate(new Date());
            order.setOrderStatus(OrderStatus.PENDING);
            order.setOrderItems(new HashSet<>(cartItems));
            orderDAO.save(order, em);
        });*/



}
