package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterController implements IController {
    private static RegisterController instance;

    private RegisterController() {
    }

    public static RegisterController getInstance() {
        if (instance == null) {
            instance = new RegisterController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        resolver.forward(ResourcePathMapper.PAGE_REGISTER.getPath());
        return resolver;
    }
}
