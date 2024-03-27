package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.Entities.Product;
import com.ecommerce.Services.ProductService;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class HomeController implements IController {
    private static HomeController instance;

    private HomeController() {
    }
    public static HomeController getInstance() {
        if (instance == null) {
            instance = new HomeController();
        }
        return instance;
    }
    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
            String method = request.getMethod();
            if (method.equals("GET")) {
                System.out.println("iam Get");
                Optional<List<Product>> optionalProducts = ProductService.getAllProducts();
                List<Product> products = optionalProducts.orElse(Collections.emptyList());

                request.setAttribute("products", products);


                resolver.forward(ResourcePathMapper.PAGE_HOME.getPath());
            } else if (method.equals("POST")) {
            }


        return resolver;
    }
}
