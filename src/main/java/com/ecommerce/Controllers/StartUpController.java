package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.Entities.Product;
import com.ecommerce.Services.ProductService;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.*;

import javax.naming.spi.Resolver;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class StartUpController implements
        IController {
    private static StartUpController instance;

    private StartUpController() {
    }

    public static StartUpController getInstance() {
        if (instance == null) {
            instance = new StartUpController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        Optional<List<Product>> optionalProducts = ProductService.getAllProducts();
        List<Product> products = optionalProducts.orElse(Collections.emptyList());

        // Convert the list of products to JSON
//                Gson gson = new Gson();
//                String json = gson.toJson(products.get(0));

        // Set the JSON data as a request attribute
        request.setAttribute("products", products);
        resolver.forward(ResourcePathMapper.PAGE_HOME.getPath());
        return resolver;
    }
}
