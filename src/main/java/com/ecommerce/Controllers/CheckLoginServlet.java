package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Services.CustomerService;
import com.ecommerce.Utils.PasswordHashing;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CheckLoginServlet implements IController {
    private static CheckLoginServlet instance;

    private CheckLoginServlet() {
    }

    public static CheckLoginServlet getInstance() {
        if (instance == null) {
            instance = new CheckLoginServlet();
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
            } else if (method.equals("POST")) {
                System.out.println("iam Post");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                System.out.println("email: " + email);
                CustomerDTO customerDTO = CustomerService.findUserByEmail(email);
                boolean correctPassword = PasswordHashing.checkPassword(password, customerDTO.getPassword());
                if(customerDTO != null && correctPassword) {
                    resolver.plainText("true");
                }
                else{
                    resolver.plainText("false");
                }
//                if (!userExists) {
//                    response.getWriter().write("true");
//                } else {
//                    response.getWriter().write("false");
//                }
            }
        } catch (Exception e) {
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            try {
                response.getWriter().write("{\"error\": \"An error occurred on the server.\"}");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return resolver;
    }
}
