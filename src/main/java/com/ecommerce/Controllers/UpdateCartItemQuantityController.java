package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.Entities.CartItem;
import com.ecommerce.Services.CartItemService;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

public class UpdateCartItemQuantityController implements IController {

    private static UpdateCartItemQuantityController instance;
    private static final Gson gson = new Gson();
    private UpdateCartItemQuantityController() {
    }

    public static UpdateCartItemQuantityController getInstance() {
        if (instance == null) {
            instance = new UpdateCartItemQuantityController();
        }
        return instance;
    }
    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if (request.getMethod().equals("POST")) {
            System.out.println("From UpdateCartItemQuantityController: iam Post");

            int cartItemId = Integer.parseInt(request.getParameter("cartItemId"));
            int newQuantity = Integer.parseInt(request.getParameter("newQuantity"));

            System.out.println("From UpdateCartItemQuantityController: cartItemId: " + cartItemId);
            System.out.println("From UpdateCartItemQuantityController: newQuantity: " + newQuantity);

            HttpSession session = request.getSession();
            Set<CartItem> cartItems = (Set<CartItem>) session.getAttribute("cartItems");

            for (CartItem item : cartItems) {
                if (item.getId().getCartId() == cartItemId) {
                    item.setQuantity(newQuantity);
                    break;
                }
            }

            session.setAttribute("cartItems", cartItems);
        }

        return resolver;
    }
}
