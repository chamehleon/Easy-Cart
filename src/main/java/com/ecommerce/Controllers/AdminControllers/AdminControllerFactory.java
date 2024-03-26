package com.ecommerce.Controllers.AdminControllers;

import com.ecommerce.Controllers.*;
import com.ecommerce.Controllers.AdminControllers.*;
import com.ecommerce.Controllers.FrontController.IController;

public class AdminControllerFactory {

    // Change
    private static AdminControllerFactory instance;

    private AdminControllerFactory() {
    }

    public static AdminControllerFactory getInstance() {
        if (instance == null) {
            instance = new AdminControllerFactory();
        }
        return instance;
    }

    public IController getController(final String controllerName) {
        switch (controllerName) {
            

            case "AdminController":
                return AdminController.getInstance();
            case "AdminProductsController":
                return AdminProductsController.getInstance();
            case "AdminAddProductController":
                return AdminAddProductController.getInstance();
            case "AdminUpdateProductController":
                return AdminUpdateProductController.getInstance();
            case "AdminAccountsController":
                return AdminAccountsController.getInstance();
            case "AdminOrderHistoryController":
                return AdminOrderHistoryController.getInstance();
            case "AdminRefreshController":
                return AdminRefreshController.getInstance();
            case "AdminLogOutController":
                return AdminLogOutController.getInstance();
            default:
            
        }
        return null;
    }
}