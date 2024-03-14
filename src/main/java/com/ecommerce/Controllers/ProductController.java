package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.Entities.Product;
import com.ecommerce.Services.ProductService;
import com.ecommerce.Utils.PasswordHashing;
import com.ecommerce.Utils.ResourcePathMapper;
import com.google.gson.Gson;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ProductController implements IController {
    private static ProductController instance;

    private ProductController() {
    }

    public static ProductController getInstance() {
        if (instance == null) {
            instance = new ProductController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if (request.getMethod().equals("GET")) {
            try {
                // Get the list of products
                Optional<List<Product>> optionalProducts = ProductService.getAllProducts();
                List<Product> products = optionalProducts.orElse(Collections.emptyList());

                // Convert the list of products to JSON
                Gson gson = new Gson();
                String json = gson.toJson(products);

                // Set the JSON data as a request attribute
                request.setAttribute("productsJson", json);

                // Forward to product.jsp
                resolver.forward(ResourcePathMapper.PAGE_PRODUCT.getPath());
            } catch (Exception e) {
                e.printStackTrace();
                response.setStatus(500); // to indicate server error
            }
        }
        return resolver;
    }
}
