package com.ecommerce.Controllers.FrontController;

import com.ecommerce.Controllers.*;

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
            case "AboutController":
                return AboutController.getInstance();
            case "ContactController":
                return ContactController.getInstance();
            case "BlogController":
                return BlogController.getInstance();
            case "BlogDetailController":
                return BlogDetailController.getInstance();
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
            case "AdminController":
                return AdminController.getInstance();
            case "ViewCartController":
                return ViewCartController.getInstance();
            case "UpdateCartItemQuantityController":
                return UpdateCartItemQuantityController.getInstance();
            case "AddToCartController":
                return AddToCartController.getInstance();
//            case "CheckoutController":
//                return CheckoutController.getInstance();


            default:
        }
        return null;
    }
}