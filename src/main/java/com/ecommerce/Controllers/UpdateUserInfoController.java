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

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

public class UpdateUserInfoController implements IController {
    private static UpdateUserInfoController instance;

    private UpdateUserInfoController() {
    }

    public static UpdateUserInfoController getInstance() {
        if (instance == null) {
            instance = new UpdateUserInfoController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(final HttpServletRequest req, final HttpServletResponse response) {
        
        CustomerService customerService = new CustomerService();
        ViewResolver resolver = new ViewResolver();
        resolver.forward(ResourcePathMapper.PAGE_LOGIN.getPath());
        if(req.getMethod().equals("GET") ) return resolver;

     
        String  username = req.getParameter("username");
        System.out.println(username);
        String  job = req.getParameter("job");
        System.out.println(job);
        String  country = req.getParameter("country");
        System.out.println(country);
        String  city = req.getParameter("city");
        System.out.println(city);
        String  streetName = req.getParameter("streetName");
        System.out.println(streetName);
        String streetNo  = req.getParameter("streetNo");
        System.out.println(streetNo);
        HttpSession session =  req.getSession();
        CustomerDTO customer =   (CustomerDTO)session.getAttribute("currentUser");
  
        customer.setCustomerName(username);
        customer.setJob(job);
        customer.setCountry(country);
        customer.setCity(city);
        customer.setStreetName(streetName);
        customer.setStreetNo(streetNo);
        session.setAttribute("currentUser", customer);
        
        if(customerService.UpdateUserEntity(customer)){
            resolver.JSON("true");
          
        }else{
            resolver.JSON("false");
        }
        return resolver;
    }
}
