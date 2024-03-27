package com.ecommerce.Services;

import com.ecommerce.Persistence.DAOs.Implementations.*;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Persistence.DTOs.ProductWithQuantityDto;
import com.ecommerce.Persistence.Entities.Cart;
import com.ecommerce.Persistence.Entities.*;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Entities.Product;
import com.ecommerce.Persistence.Mappers.CustomerMapper;
import com.ecommerce.Utils.JpaTransactionManager;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CartService {


    // retrieveAllCartItems from customer
    public static Set<CartItem> viewCart(Integer customerId) {
        return JpaTransactionManager.doInTransaction(em -> {
            CustomerDAO customerDAO = new CustomerDAO();
            Customer customer = customerDAO.findById(customerId, em);
            CartDAO cartDAO = new CartDAO();
            return cartDAO.getCartItemsByCustomer(customer, em);
        });
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

    public static Cart getCartFromCustomerId(Integer customerId){
        return JpaTransactionManager.doInTransaction(em->{
            CustomerDAO customerRepo = new CustomerDAO();
            Customer customer = customerRepo.findById(customerId, em);
            return customer.getCart();
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
            CartItemDAO cartItemDAO = new CartItemDAO();
            return cartItemDAO.retrieveProductWithQuantityDtoRepo(cartId, em);
        });
    }
    // ================== for checkout part ==================
    public static BigDecimal getTotalAmount(CustomerDTO customerDto){
        return JpaTransactionManager.doInTransaction(em->{
            Customer customer = CustomerMapper.INSTANCE.toEntity(customerDto);
            Integer cartId = getCartFromCustomerId(customer.getId()).getId();
            Set<CartItem> cartItems = getCartItems(cartId).get();
            BigDecimal total = new BigDecimal("0.0");
            for(CartItem item : cartItems){
                total = total.add(item.getAmount());
            }
            System.out.println("Total amount: "+total);
            return total;
        });

    }
    private static String checkQuantityBeforeCheckOut(CustomerDTO customerDto){
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDto);
        Integer cartId = getCartFromCustomerId(customer.getId()).getId();
        Set<CartItem> cartItems = getCartItems(cartId).get();
        for(CartItem item : cartItems){
            if(item.getProduct().getStockQuantity()<item.getQuantity()){
                return "Sorry, "+item.getProduct().getProductName()+" is currently out of stock.";
            }

        }
        return "ALL_Products_Available";
    }
    private static Optional<Set<CartItem>> getCartItems(Integer cartId){
        return JpaTransactionManager.doInTransaction(em->{
            CartDAO cartRepo = new CartDAO();
            Cart cart = getCartById(cartId);
            if (cart == null) {
                throw new RuntimeException("getCartItems method + Cart not found for id: " + cartId);
            }
            return Optional.of(cart.getCartItems());
        });
    }
    private static Cart getCartById(Integer cartId){
        return JpaTransactionManager.doInTransaction(em-> {
            CartDAO cartDAO = new CartDAO();
            return  cartDAO.findById(cartId, em);
        });
    }
    private static void clearCart(Integer cartId){
        JpaTransactionManager.doInTransactionWithoutResult(em->{
            Query query = em.createQuery("DELETE  FROM CartItem c WHERE c.cart.id = :cartId");
            query.setParameter("cartId", cartId);
            query.executeUpdate();
        });
    }

    public static String checkout(CustomerDTO customerDto){
        return JpaTransactionManager.doInTransaction(em->{
            CustomerDAO customerDAO = new CustomerDAO();
            Customer customer = CustomerMapper.INSTANCE.toEntity(customerDto);
            customer = customerDAO.findUserByEmail(customer.getEmail(),em).get();
            System.out.println("today "+customer.getEmail());
            Integer cartId = getCartIdByCustomerId(customer.getId()).get();
            System.out.println("today "+cartId);

            String checkQuantity = checkQuantityBeforeCheckOut(customerDto);
            System.out.println("today "+checkQuantity);
            if(!checkQuantity.equals("ALL_Products_Available")){
                return checkQuantity;
            }
            BigDecimal total = getTotalAmount(customerDto);
            if(customer.getCreditLimit().compareTo(total)<0){
                return "Insufficient credit";
            }
            handleOrder(cartId,customer,em);
            clearCart(cartId);
            customer.setCreditLimit(customer.getCreditLimit().subtract(total));
            return "success";
        });
    }

    private static void handleOrder(Integer cartId, Customer customer, EntityManager em){
        Cart cart = getCartById(cartId);
        if (cart == null) {
            throw new RuntimeException("Cart not found for id: " + cartId);
        }
        Order order = new Order();
        order.setCustomer(customer);
        Instant orderedAt = Instant.now();
        order.setOrderedAt(orderedAt);
        OrderDAO orderDAO = new OrderDAO();

        for (CartItem cartItem : cart.getCartItems()){
            Product product = new Product();
            product = em.find(Product.class, cartItem.getProduct().getId());
            product.setStockQuantity(product.getStockQuantity() - cartItem.getQuantity());
            order.addOrderItem(product,cartItem.getQuantity(),cartItem.getAmount());
        }

        orderDAO.create(order, em);
    }


    public static void updateCartItemQuantity(CartItem cartItem, Integer quantity){
        JpaTransactionManager.doInTransactionWithoutResult(em->{
            CartItemDAO cartItemDAO = new CartItemDAO();
            cartItem.setQuantity(quantity);
            cartItem.setAmount(cartItem.getProduct().getProductPrice().multiply(new BigDecimal(quantity)));
            cartItemDAO.update(cartItem, em);
        });
    }

}
