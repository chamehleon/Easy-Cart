package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class BlogController implements IController {

    private static com.ecommerce.Controllers.BlogController instance;

    private BlogController() {
    }

    public static com.ecommerce.Controllers.BlogController getInstance() {
        if (instance == null) {
            instance = new com.ecommerce.Controllers.BlogController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        String method = request.getMethod();
        if (method.equals("GET")) {
            System.out.println("iam Get");
            resolver.forward(ResourcePathMapper.PAGE_BLOG.getPath());
        } else if (method.equals("POST")) {
        }


        return resolver;
    }
}




