package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ErrorPageController implements IController {
    private static ErrorPageController instance;

    private ErrorPageController() {
    }

    public static com.ecommerce.Controllers.ErrorPageController getInstance() {
        if (instance == null) {
            instance = new com.ecommerce.Controllers.ErrorPageController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        String method = request.getMethod();
        if (method.equals("GET")) {
            System.out.println("iam Get");
            resolver.forward(ResourcePathMapper.PAGE_ERROR.getPath());
        } else if (method.equals("POST")) {
        }


        return resolver;
    }

}
