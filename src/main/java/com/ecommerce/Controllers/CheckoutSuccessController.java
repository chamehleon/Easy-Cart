package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CheckoutSuccessController implements IController {
    private static CheckoutSuccessController instance;

    private CheckoutSuccessController() {
    }

    public static CheckoutSuccessController getInstance() {
        if (instance == null) {
            instance = new CheckoutSuccessController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        String method = request.getMethod();
        if (method.equals("GET")) {
            System.out.println("iam Get");
            resolver.forward(ResourcePathMapper.PAGE_CHECKOUT_SUCCESS.getPath());
        } else if (method.equals("POST")) {
        }


        return resolver;
    }
}
