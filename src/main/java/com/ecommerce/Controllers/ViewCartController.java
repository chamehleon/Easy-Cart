package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Persistence.Entities.CartItem;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Mappers.CustomerMapper;
import com.ecommerce.Services.CartService;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Set;

public class ViewCartController implements IController {

    private static ViewCartController instance;

    private ViewCartController() {
    }
    public static ViewCartController getInstance() {
        if (instance == null) {
            instance = new ViewCartController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        try {
            String method = request.getMethod();
            if (method.equals("GET")) {
                System.out.println("ViewCartController: GET");
                HttpSession session = request.getSession(false);
                if (session == null || session.getAttribute("currentUser") == null) {
                    resolver.forward(ResourcePathMapper.PAGE_LOGIN.getPath());
                } else {
                    Customer customer = CustomerMapper.INSTANCE.toEntity((CustomerDTO) session.getAttribute("currentUser"));
                    Set<CartItem> cartItems = CartService.viewCart(customer.getId());

                    session.setAttribute("cartItems", cartItems);
                    resolver.forward(ResourcePathMapper.PAGE_CART.getPath());
                }

            } else if (method.equals("POST")) {
                System.out.println("ViewCartController: POST");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(500);
        }
        return resolver;
    }
}

