package com.ecommerce.Controllers.FrontController;

import com.ecommerce.Controllers.*;
import org.eclipse.tags.shaded.org.apache.regexp.RE;

public class ControllerFactory {
    private static ControllerFactory instance;

    private ControllerFactory() {
    }

    public static ControllerFactory getInstance() {
        if (instance == null) {
            instance = new ControllerFactory();
        }
        return instance;
    }

    public IController getController(final String controllerName) {
        switch (controllerName) {
            case "Cart":
                return CartController.getInstance();
            case "RegisterController":
                return RegisterController.getInstance();
            case "LoginController":
                return LoginController.getInstance();
            case "CheckEmailServlet":
                return CheckEmailServlet.getInstance();
            case "FetchProducts":
                return ProductController.getInstance();

            default:
        }
        return null;
    }
}