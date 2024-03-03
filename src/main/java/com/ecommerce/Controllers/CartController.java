package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.*;

public class CartController implements IController {

    private static CartController instance;

    private CartController() {
    }

    public static CartController getInstance() {
        if (instance == null) {
            instance = new CartController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(final HttpServletRequest request, final HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        resolver.forward(ResourcePathMapper.PAGE_CART.getPath());
        return resolver;
    }
}
