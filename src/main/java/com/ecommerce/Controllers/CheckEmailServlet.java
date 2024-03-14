package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Services.CustomerService;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CheckEmailServlet implements IController {
    private static CheckEmailServlet instance;

    private CheckEmailServlet() {
    }

    public static CheckEmailServlet getInstance() {
        if (instance == null) {
            instance = new CheckEmailServlet();
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
                boolean userExists = CustomerService.isUserExists(email);



                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                if (!userExists) {
                    response.getWriter().write("{\"emailExists\": false}");
                    System.out.println("From CheckEmailServlet POST: emailExists: false");
                } else {
                    response.getWriter().write("{\"emailExists\": true}");
                    System.out.println("From CheckEmailServlet POST: emailExists: true");
                }
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
