package com.ecommerce.Controllers.AdminControllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Services.CustomerService;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.*;

import java.util.Collections;
import java.util.List;

public class AdminAccountsController implements IController {
private static AdminAccountsController instance;

    private AdminAccountsController() {
    }

    public static AdminAccountsController getInstance() {
        if (instance == null) {
            instance = new AdminAccountsController();
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
                List<Customer> customers = CustomerService.getAllCustomers().orElse(Collections.emptyList());
                request.setAttribute("customers", customers);


                resolver.forward(ResourcePathMapper.PAGE_ADMIN_ACCOUNTS.getPath());
            } else if (method.equals("POST")) {
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return resolver;
    }

}
