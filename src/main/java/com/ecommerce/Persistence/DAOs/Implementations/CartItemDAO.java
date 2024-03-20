package com.ecommerce.Persistence.DAOs.Implementations;

import com.ecommerce.Persistence.DAOs.GenericDAOs.GenericDAOImpl;
import com.ecommerce.Persistence.Entities.Cart;
import com.ecommerce.Persistence.Entities.CartItem;

public class CartItemDAO extends GenericDAOImpl<CartItem> {
    public CartItemDAO() {
        super(CartItem.class);
    }


}
