package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
                resolver.forward(ResourcePathMapper.PAGE_HOME.getPath());
            } else if (method.equals("POST")) {
            }


        return resolver;
    }
}
