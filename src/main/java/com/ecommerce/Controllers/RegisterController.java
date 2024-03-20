package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
//import com.ecommerce.Services.RegisterService;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Services.CustomerService;
import com.ecommerce.Utils.PasswordHashing;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.math.BigDecimal;
import java.time.LocalDate;

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
    public ViewResolver resolve(final HttpServletRequest req, final HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        try {
            String method = req.getMethod();
            if (method.equals("GET")) {
                System.out.println("iam Get");
                resolver.forward(ResourcePathMapper.PAGE_REGISTER.getPath());
            } else if (method.equals("POST")) {
                System.out.println("iam Post");
                String username = req.getParameter("username");
                String password = req.getParameter("password");
                String email = req.getParameter("email");

                String hashedPassword = PasswordHashing.hashPassword(password);

                LocalDate birthdate = LocalDate.now();
                Customer customer = new Customer(
                        username,
                        birthdate,
                        hashedPassword,
                        "none",
                        email,
                        new BigDecimal(0),
                        "none",
                        "none",
                        "none",
                        "none",
                        "none"
                );
                //TODO customerdto 5aleeh customer entity

                boolean registeredSuccessfully = CustomerService.register(customer);
                if (registeredSuccessfully) {
                    System.out.println("registeredSuccessfully = true");
                    resolver.forward(ResourcePathMapper.PAGE_PRODUCT.getPath());
                } else {
                    System.out.println("registeredSuccessfully = false");
                    resolver.forward(ResourcePathMapper.PAGE_REGISTER.getPath());
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return resolver;
    }
}
