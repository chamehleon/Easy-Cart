package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
//import com.ecommerce.Services.RegisterService;
import com.ecommerce.Services.RegisterService;
import com.ecommerce.Utils.EntityManagerThreadLocalUtil;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RegisterController implements IController {
    private static RegisterController instance;
    private final RegisterService registerService = new RegisterService();
   //// private final RegisterService registerService;

    private RegisterController() {
    //    registerService= new RegisterService();
    }

    public static RegisterController getInstance() {
        if (instance == null) {
            instance = new RegisterController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(final HttpServletRequest req, final HttpServletResponse response) {
        EntityManagerThreadLocalUtil.init(req.getServletContext());
        ViewResolver resolver = new ViewResolver();
        try {
            // Your existing code to handle the request goes here

        String method = req.getMethod();
        if (method.equals("GET")) {
            System.out.println("iam Get");
            resolver.forward(ResourcePathMapper.PAGE_REGISTER.getPath());
        } else if (method.equals("POST")) {
            System.out.println("iam Post");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");

            CustomerDTO customerDTO = new CustomerDTO(
                    "omar",
                    "password123",
                    "omar@example.com"
            );

            // If this request needs an EntityManager
//            EntityManagerThreadLocalUtil.init(request.getServletContext());
//            try {
//                // Handle the request, use services, etc.
//            } finally {
//                EntityManagerThreadLocalUtil.closeEntityManager();
//            }

            boolean registeredSuccessfully = registerService.registerUser(customerDTO);;
            if (registeredSuccessfully) {
                System.out.println("registeredSuccessfully = true");
                resolver.forward(ResourcePathMapper.PAGE_PRODUCT.getPath());
            } else {
                System.out.println("registeredSuccessfully = false");
                resolver.forward(ResourcePathMapper.PAGE_REGISTER.getPath());
            }

/*
            String job = req.getParameter("job");
            String country = req.getParameter("country");
            String city = req.getParameter("city");
            String streetNo = req.getParameter("streetNo");
            String streetName = req.getParameter("streetName");
            BigDecimal credit = new BigDecimal(req.getParameter("credit"));
            LocalDate birthdate = LocalDate.parse(req.getParameter("birthdate"));
            LocalDate now = LocalDate.now();

            // CustomerDTO customerDTO = new CustomerDTO("username","birthdate","password", "job", "email", credit, city, country, streetNo, streetName, "none");
        boolean isRegister = registerService.registerUser(customerDTO);;
            if(isRegister) {
                System.out.println("isRegister = true");
                resolver.forward(ResourcePathMapper.PAGE_PRODUCT.getPath());

            }else {
                resolver.forward(ResourcePathMapper.PAGE_REGISTER.getPath());
            }
        */
        }
        } finally {
            EntityManagerThreadLocalUtil.closeEntityManager();
        }
        return resolver;
    }
}
