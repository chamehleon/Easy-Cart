package com.ecommerce.Services;

import com.ecommerce.Persistence.DAOs.Implementations.CartDAO;
import com.ecommerce.Persistence.DAOs.Implementations.CustomerDAO;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Persistence.Entities.CartItem;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Mappers.CustomerMapper;
import com.ecommerce.Utils.JpaTransactionManager;
import jakarta.persistence.EntityManager;

import java.util.Optional;
import java.util.Set;

public class CartService {
    public static Set<CartItem> viewCart(Customer customer) {
        CartDAO cartDAO = new CartDAO();
        return JpaTransactionManager.doInTransaction(em -> cartDAO.getAllCartItems(customer, em));
    }





}
