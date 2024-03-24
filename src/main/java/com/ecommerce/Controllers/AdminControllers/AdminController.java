package com.ecommerce.Controllers.AdminControllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminController implements IController {

    private static AdminController instance;

    private AdminController() {
    }
    public static AdminController getInstance() {
        if (instance == null) {
            instance = new AdminController();
        }
        return instance;
    }
    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        try {
            String method = request.getMethod();
            if (method.equals("GET")) {
                System.out.println("iam Get");
                resolver.forward(ResourcePathMapper.PAGE_ADMIN_LOGIN.getPath());
            } else if (method.equals("POST")) {
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return resolver;
    }
}
