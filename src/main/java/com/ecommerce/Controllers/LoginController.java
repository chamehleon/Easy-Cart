package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Persistence.DTOs.ProductWithQuantityDto;
import com.ecommerce.Persistence.Entities.Cart;
import com.ecommerce.Services.CartService;
import com.ecommerce.Services.CustomerService;
import com.ecommerce.Utils.PasswordHashing;
import com.ecommerce.Utils.ResourcePathMapper;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

public class LoginController implements IController {
    private static LoginController instance;

    private LoginController() {
    }

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }


    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = null;
        if (request.getMethod().equals("POST")) {
            System.out.println("From LoginController: iam Post");
            try {
                resolver = process(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else if (request.getMethod().equals("GET")) {
            System.out.println("From LoginController: iam Get");
            resolver = new ViewResolver(ResourcePathMapper.PAGE_LOGIN.getPath());
        }
        return resolver;
    }

    public ViewResolver process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewResolver resolver = new ViewResolver();
        String email = (String) req.getParameter("email");
        String password = (String) req.getParameter("password");
        CustomerDTO customerDTO = CustomerService.findUserByEmail(email);
        boolean correctPassword = PasswordHashing.checkPassword(password, customerDTO.getPassword());
        System.out.println("From LoginController: " + customerDTO.toString());
        if (customerDTO != null && correctPassword) {
            HttpSession session = req.getSession(true);
            session.setAttribute("currentUser", customerDTO);
//         resolver.forward(ResourcePathMapper.PAGE_HOME.getPath());
            System.out.println("ana gowa el loginnnn");
            Cart cart = CartService.getCartByCustomerId(customerDTO.getId());
            String productIdsJson = req.getParameter("productIds");
            String QuantitiesJson = req.getParameter("quantities");
            // Parse productIds JSON string to int array using Gson
            Gson gson = new Gson();
            Integer[] productIds = gson.fromJson(productIdsJson, Integer[].class);
            int[] quantities = gson.fromJson(QuantitiesJson, int[].class);
            // Parse productIds to int array
            if (cart == null) {
                CartService.createCart(customerDTO);
                //add All products to cartItems table -> addProductToCart(Integer productId,Integer customerId)
                // for All Products
                if (productIds != null) {
                    for (int productId : productIds) {
                        CartService.addProductToCart(productId, customerDTO.getId());
                    }
                }
            } else {
                List<ProductWithQuantityDto> productsNotInLocalStorage;
                // already have cart
                // cartId + prouctID and check if this cartItem with these ids is exist
                // if exist update quantity of this cartItem
                if (productIds != null) {
                    for (int i = 0; i < productIds.length; i++) {
                        CartService.editQuantityOrAddIfNotExist(cart.getId(), productIds[i], customerDTO.getId(), quantities[i]);
                    }
                    productsNotInLocalStorage = CartService.retrieveCartItemNotExistInLocalStorage(cart.getId(), productIds);

                } else {
                    productsNotInLocalStorage = CartService.retrieveProductWithQuantityDto(cart.getId());

                }
                String cartItemsNotInLocalStorageJson = gson.toJson(productsNotInLocalStorage);
                System.out.println("cartItemsNotInLocalStorageJson " + cartItemsNotInLocalStorageJson);
                // Set the appropriate content type and character encoding
                System.out.println("write Json");
                resolver.plainText(cartItemsNotInLocalStorageJson);
            }
        } else {
            resolver.plainText("Incorrect credentials");
        }
        return resolver;
    }


//    public ViewResolver process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ViewResolver resolver = new ViewResolver();
//        String email = (String) req.getParameter("email");
//        String password = (String) req.getParameter("password");
//        CustomerDTO customerDTO = CustomerService.findUserByEmail(email);
//        boolean correctPassword = PasswordHashing.checkPassword(password, customerDTO.getPassword());
//        System.out.println("From LoginController: " + customerDTO.toString());
//        if(customerDTO != null && correctPassword ){
//            HttpSession session = req.getSession(true);
//            session.setAttribute("currentUser", customerDTO);
//            if (customerDTO.getEmail().equals("ee")) {
//                System.out.println("ANA ADMIN");
//                resolver.forward(ResourcePathMapper.PAGE_ADMIN.getPath());
//            } else {
//                resolver.forward(ResourcePathMapper.PAGE_HOME.getPath());
//            }
//        }else {
//            resp.setContentType("application/json");
//            resp.setCharacterEncoding("UTF-8");
//            resp.getWriter().write("{ \"loginfailed\": " + true + " }");
//        }
//        return resolver;
//    }
}
