package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ContactController implements IController {

    private static ContactController instance;

    private ContactController() {
    }

    public static ContactController getInstance() {
        if (instance == null) {
            instance = new ContactController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        String method = request.getMethod();
        if (method.equals("GET")) {
            System.out.println("iam Get");
            resolver.forward(ResourcePathMapper.PAGE_CONTACT.getPath());
        } else if (method.equals("POST")) {
        }


        return resolver;
    }
}


