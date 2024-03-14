package com.ecommerce.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/LoginStatusServlet")
public class LoginStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = (String) request.getSession().getAttribute("username");
        boolean isLoggedIn = (username != null);
        System.out.println("aaaaaaaaaaaaaaaa");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write("{\"isLoggedIn\": " + isLoggedIn + "}");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

