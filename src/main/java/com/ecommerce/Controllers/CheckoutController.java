package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Persistence.Entities.Cart;
import com.ecommerce.Persistence.Entities.CartItem;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Entities.Product;
import com.ecommerce.Services.CartService;
import com.ecommerce.Services.OrderService;
import com.ecommerce.Utils.ResourcePathMapper;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CheckoutController implements IController {
    private static CheckoutController instance;

    private CheckoutController() {
    }

    public static CheckoutController getInstance() {
        if (instance == null) {
            instance = new CheckoutController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if (request.getMethod().equals("GET")) {
            System.out.println("Checkout controller GET");
            HttpSession session = request.getSession(false);
            if (session == null || session.getAttribute("currentUser") == null) {
                System.out.println("User not logged in");
                resolver.forward(ResourcePathMapper.PAGE_LOGIN.getPath());
            } else {
                System.out.println("User logged in");
               String result = CartService.checkout((CustomerDTO) session.getAttribute("currentUser"));
                System.out.println("result  "+result);
               if (result.equals("success")) {
                   resolver.plainText("checkout is done bro");
                   // put orderID on session
                   Integer orderID = OrderService.getMostRecentOrderPrimaryKeyByCustomer((CustomerDTO) session.getAttribute("currentUser"));
                     session.setAttribute("orderID", orderID);
               } else {
                   resolver.plainText(result);
               }
            }
        } else if (request.getMethod().equals("POST")) {
            System.out.println("Checkout controller POST");
        }

        System.out.println("eeeeeeeeeeeeeeee   "+resolver.getResolveAction());
        return resolver;
    }

}
