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

public class ProductDetailController implements IController {

    private static ProductDetailController instance;

    private ProductDetailController() {
    }

    public static ProductDetailController getInstance() {
        if (instance == null) {
            instance = new ProductDetailController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        if (request.getMethod().equals("GET")) {
            try {
                String productId = request.getParameter("productId");
                // Fetch product information using productId
                Product product = ProductService.getProductById(Integer.parseInt(productId));
                // Now you have the product object, you can use it as needed
                request.setAttribute("product", product);
                resolver.forward(ResourcePathMapper.PAGE_PRODUCT_DETAIL.getPath());
            } catch (Exception e) {
                e.printStackTrace();
                response.setStatus(500);
            }
        }
        return resolver;
    }
}
