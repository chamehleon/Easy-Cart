package com.ecommerce.Services;

import com.ecommerce.Persistence.DAOs.Implementations.CartItemDAO;
import com.ecommerce.Persistence.Entities.CartItem;
import com.ecommerce.Utils.JpaTransactionManager;

public class CartItemService {
    public static CartItem updateCartItemQuantity(int cartItemId, int newQuantity) {
        return JpaTransactionManager.doInTransaction(em -> {
            CartItemDAO cartItemDAO = new CartItemDAO();
            CartItem cartItem =  cartItemDAO.findById(cartItemId, em);
            if (cartItem != null) {
                cartItem.setQuantity(newQuantity);
            }
            return cartItem;
        });
    }
}
