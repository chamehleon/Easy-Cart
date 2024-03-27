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
import jakarta.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MyAccountController implements IController {
    private static MyAccountController instance;

    private MyAccountController() {
    }

    public static MyAccountController getInstance() {
        if (instance == null) {
            instance = new MyAccountController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(final HttpServletRequest req, final HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        try {
           
           
               HttpSession session = req.getSession(false);

                if (session == null ) {
                    resolver.forward(ResourcePathMapper.PAGE_ABOUT.getPath());
                    
                } else{
                
                    resolver.forward(ResourcePathMapper.PAGE_PROFILE.getPath());

                }
                
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return resolver;
    }
}
