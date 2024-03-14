package com.ecommerce.Controllers;

import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Services.CustomerService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/checko")
public class checko extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
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
                System.out.println("ezz");
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in CheckEmailServlet");

        }

    }
}

