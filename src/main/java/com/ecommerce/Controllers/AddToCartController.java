package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Services.CartService;
import com.ecommerce.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class AddToCartController implements IController {
    private static AddToCartController instance;

    private AddToCartController() {}
    public static AddToCartController getInstance() {
        if (instance == null) {
            instance = new AddToCartController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response)
    {
        ViewResolver resolver = new ViewResolver();
        // remove mel cart 3mltha fel GET method bt3 el add to cart badl new controller
        if(request.getMethod().equals("GET")) {
            System.out.println("Add to cart controller GET");
            HttpSession session = request.getSession(false);
            System.out.println("session is " + session.getAttribute("currentUser"));
            CustomerDTO customerDto = (CustomerDTO) session.getAttribute("currentUser");
            System.out.println("checkkckckk " +customerDto.toString());
            if(customerDto != null){
                Optional<Integer> cartId = CartService.getCartIdByCustomerId(customerDto.getId());
                Integer productId = Integer.parseInt(request.getParameter("productId"));
                CartService.removeCartItemFromCart(cartId.get(), productId);
                System.out.println("cartitem deleted from db");
            }
            resolver.plainText("deleted from login controller GET");
        }
        else if(request.getMethod().equals("POST")) {
            System.out.println("Add to cart controller POST");
            Integer productId = Integer.parseInt(request.getParameter("productId"));
            System.out.println("Id is " + productId);
            HttpSession session = request.getSession(false);
            CustomerDTO customerDto = (CustomerDTO) session.getAttribute("currentUser");
            if(!ProductService.sufficientQuantity(productId))
            {
                System.out.println("5elst");
                resolver.plainText("false");
            }else
            System.out.println("customer id is " + customerDto.getId());
                if(CartService.addProductToCart(productId, customerDto.getId())) {
                    System.out.println("available");
                    resolver.plainText("true");
                }
                else{
                    System.out.println("msh haykafy");
                    resolver.plainText("false");
                }

//                else if(request.getMethod().equals("GET")){
//                HttpSession session = request.getSession(false);
//                CustomerDto customerDto = (CustomerDto) session.getAttribute("customer");
//                if(customerDto != null){
//                    Optional<Integer> cartId = CustomerService.getCartIdByCustomerId(customerDto.getId());
//                    Integer productId = Integer.parseInt(request.getParameter("productId"));
//                    CartService.removeCartItemFromCart(cartId.get(),productId);
//                    System.out.println("cartitem deleted from db");
//                }
//                }

        }
        return resolver;
    }
}













