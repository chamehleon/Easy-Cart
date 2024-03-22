package com.ecommerce.Controllers.AdminControllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.Entities.Category;
import com.ecommerce.Persistence.Entities.Product;
import com.ecommerce.Services.CategoryService;
import com.ecommerce.Services.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ecommerce.Utils.ResourcePathMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AdminProductController implements IController {
    private static AdminProductController instance;

    private AdminProductController() {
    }

    public static AdminProductController getInstance() {
        if (instance == null) {
            instance = new AdminProductController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        try {
            String method = request.getMethod();
            if (method.equals("GET")) {
                Optional<List<Product>> optionalProducts = ProductService.getAllProducts();
                List<Product> products = optionalProducts.orElse(Collections.emptyList());

                Optional<List<Category>> optionalCategories = CategoryService.getAllCategories();
                List<Category> categories = optionalCategories.orElse(Collections.emptyList());

                request.setAttribute("categories", categories);
                request.setAttribute("products", products);
                resolver.forward(ResourcePathMapper.PAGE_ADMIN_PRODUCT.getPath());
            } else if (method.equals("POST")) {


            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return resolver;
    }
}
