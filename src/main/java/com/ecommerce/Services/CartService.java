package com.ecommerce.Services;

import com.ecommerce.Persistence.DAOs.Implementations.CartDAO;
import com.ecommerce.Persistence.DAOs.Implementations.CartItemDAO;
import com.ecommerce.Persistence.DAOs.Implementations.CustomerDAO;
import com.ecommerce.Persistence.DAOs.Implementations.ProductDAO;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Persistence.DTOs.ProductWithQuantityDto;
import com.ecommerce.Persistence.Entities.Cart;
import com.ecommerce.Persistence.Entities.CartItem;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Entities.Product;
import com.ecommerce.Persistence.Mappers.CustomerMapper;
import com.ecommerce.Utils.JpaTransactionManager;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CartService {
    public static Set<CartItem> viewCart(Customer customer) {
        CartDAO cartDAO = new CartDAO();
        return JpaTransactionManager.doInTransaction(em -> cartDAO.getAllCartItems(customer, em));
    }


    public static void createCart(CustomerDTO customerDto) {
        JpaTransactionManager.doInTransactionWithoutResult(em -> {
            Cart cart = new Cart();
            cart.setCustomer(CustomerMapper.INSTANCE.toEntity(customerDto));
            CartDAO cartDAO = new CartDAO();
            cartDAO.create(cart, em);
        });
    }


    public static boolean addProductToCart(Integer productId, Integer customerId) {
        return JpaTransactionManager.doInTransaction(em -> {
            ProductDAO productDAO = new ProductDAO();
            Product product = productDAO.findById(productId, em);

            CustomerDAO customerDAO = new CustomerDAO();
            Customer customer = customerDAO.findById(customerId, em);

            Cart cart = customer.getCart();

            Optional<CartItem> cartItemOptional = cartItemExists(cart.getId(), product.getId());
            if (cartItemOptional.isPresent()) {
                CartItem cartItem = cartItemOptional.get();
                if (cartItem.getQuantity() + 1 <= product.getStockQuantity()) {
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    cartItem.setAmount(new BigDecimal(cartItem.getQuantity()).multiply(product.getProductPrice()));
                    CartItemDAO cartItemDAO = new CartItemDAO();
                    cartItemDAO.update(cartItem, em);
                    return true;
                } else
                    return false;
            } else {
                cart.addCartItem(product, 1, product.getProductPrice());
                CartDAO cartDAO = new CartDAO();
                cartDAO.update(cart, em);
                return true;
            }

        });
    }

    public static Optional<Integer> getCartIdByCustomerId(Integer customerId) {
        return JpaTransactionManager.doInTransaction(em -> {
            CustomerDAO customerDAO = new CustomerDAO();
            Customer customer = customerDAO.findById(customerId, em);
            return Optional.of(customer.getCart().getId());
        });
    }

    public static Cart getCartByCustomerId(Integer customerId) {
        return JpaTransactionManager.doInTransaction(em -> {
            CustomerDAO customerDAO = new CustomerDAO();
            Customer customer = customerDAO.findById(customerId, em);
            return customer.getCart();
        });
    }


    private static Optional<CartItem> cartItemExists(Integer cartId, Integer productId) {
        return JpaTransactionManager.doInTransaction(em -> {
            CartDAO cartDAO = new CartDAO();
            Cart cart = cartDAO.findById(cartId, em);
            for (CartItem cartItem : cart.getCartItems()) {
                if (cartItem.getProduct().getId() == productId) {
                    return Optional.of(cartItem);
                }
            }
            return Optional.empty();
        });
    }


    public static boolean removeCartItemFromCart(Integer cartId, Integer productId) {
        System.out.println("removeCartItemFromCart!!!!!!!!");
        return JpaTransactionManager.doInTransaction(em -> {
            CartDAO cartDAO = new CartDAO();
            Cart cart = cartDAO.findById(cartId, em);
            CartItem cartItem = null;
            for (CartItem item : cart.getCartItems()) {
                if (item.getProduct().getId() == productId) {
                    cartItem = item;
                    break;
                }
            }
            if (cartItem != null) {
                cart.removeCartItem(cartItem);
                CartItemDAO cartItemDAO = new CartItemDAO();
                cartItemDAO.delete(cartItem, em);
                return true;
            } else {
                return false;
            }
        });
    }

    public static boolean clearCart(List<CartItem> cartItems) {
        return JpaTransactionManager.doInTransaction(em -> {
            CartItemDAO cartItemDAO = new CartItemDAO();
            for (CartItem cartItem : cartItems) {
                cartItemDAO.delete(cartItem, em);
            }
            return true;
        });
    }

    public  static void editQuantityOrAddIfNotExist(Integer cartId,Integer productId,Integer customerId,Integer quantity){
        Optional<CartItem> cartItem = cartItemExists(cartId,productId);
        boolean isaCartItemExist = cartItem.isPresent();
        if(isaCartItemExist){
            // get quantity
            editQuantityOfCartItem(cartItem.get(),quantity);
        }else{
            addProductToCart(productId,customerId);
        }
    }

    private static void editQuantityOfCartItem(CartItem cartItem,Integer quantity){
        JpaTransactionManager.doInTransactionWithoutResult(em->{
            CartItemDAO cartItemDAO = new CartItemDAO();
            cartItem.setQuantity(quantity);
            cartItem.setAmount(cartItem.getProduct().getProductPrice().multiply(new BigDecimal(quantity)));
            cartItemDAO.update(cartItem, em);
        });
    }

    public static List<ProductWithQuantityDto> retrieveCartItemNotExistInLocalStorage(int cartId, Integer[] productIds) {
        return JpaTransactionManager.doInTransaction(em->{
            CartItemDAO cartItemDAO = new CartItemDAO();
            return cartItemDAO.retrieveCartItemNotExistInLocalStorageRepo(cartId,productIds , em);
        });
    }

    public static List<ProductWithQuantityDto> retrieveProductWithQuantityDto(int cartId) {
        return JpaTransactionManager.doInTransaction(em->{
            CartItemDAO cartItemRepo = new CartItemDAO();
            return cartItemRepo.retrieveProductWithQuantityDtoRepo(cartId, em);
        });
    }

}
