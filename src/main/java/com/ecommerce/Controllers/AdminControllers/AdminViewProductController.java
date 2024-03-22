package com.ecommerce.Controllers.AdminControllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.Entities.Product;
import com.ecommerce.Services.ProductService;
import com.ecommerce.Utils.ResourcePathMapper;
import com.google.gson.Gson;
import jakarta.servlet.http.*;

import java.io.BufferedReader;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class AdminViewProductController implements IController {
    private static AdminViewProductController instance;

    private AdminViewProductController() {
    }

    public static AdminViewProductController getInstance() {
        if (instance == null) {
            instance = new AdminViewProductController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        try {
            String method = request.getMethod();
            if (method.equals("GET")) {
                System.out.println("me here");
                int productId = Integer.parseInt(request.getParameter("id"));
                Optional<Product> optionalProducts = ProductService.getProductById(productId);
                Product product = optionalProducts.orElse(null);
                request.setAttribute("product", product);
                resolver.forward(ResourcePathMapper.PAGE_ADMIN_VIEW_PRODUCT.getPath());
            } else if (method.equals("POST")) {
                int productId = Integer.parseInt(request.getParameter("id"));

                Optional<Product> optionalProducts = ProductService.getProductById(productId);
                Product product = optionalProducts.orElse(null);
                request.setAttribute("product", product);
                resolver.forward(ResourcePathMapper.PAGE_ADMIN_VIEW_PRODUCT.getPath());


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resolver;
    }
}
