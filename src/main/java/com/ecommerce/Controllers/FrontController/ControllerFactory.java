package com.ecommerce.Controllers.FrontController;

import com.ecommerce.Controllers.*;
import com.ecommerce.Controllers.AdminControllers.AdminAddProductController;
import com.ecommerce.Controllers.AdminControllers.AdminController;
import com.ecommerce.Controllers.AdminControllers.AdminProductController;
import com.ecommerce.Controllers.AdminControllers.AdminViewProductController;

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
            case "HomeController":
                return HomeController.getInstance();
            case "RegisterController":
                return RegisterController.getInstance();
            case "LoginController":
                return LoginController.getInstance();
            case "CheckEmailServlet":
                return CheckEmailServlet.getInstance();
            case "FetchProducts":
                return ProductController.getInstance();
            case "ProductDetailController":
                return ProductDetailController.getInstance();
            case "ViewCartController":
                return ViewCartController.getInstance();
            case "UpdateCartItemQuantityController":
                return UpdateCartItemQuantityController.getInstance();
            case "AdminController":
                return AdminController.getInstance();
            case "AdminProductController":
                return AdminProductController.getInstance();
            case "AdminAddProductController":
                return AdminAddProductController.getInstance();
            case "AdminViewProductController":
                return AdminViewProductController.getInstance();
            default:
        }
        return null;
    }
}