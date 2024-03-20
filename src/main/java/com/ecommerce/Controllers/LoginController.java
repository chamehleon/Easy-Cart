package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Services.CustomerService;
import com.ecommerce.Utils.PasswordHashing;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginController implements IController {
    private static LoginController instance;

    private LoginController() {
    }

    public static LoginController getInstance() {
        if (instance == null) {
            instance = new LoginController();
        }
        return instance;
    }


    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = null;
        if (request.getMethod().equals("POST")) {
            System.out.println("From LoginController: iam Post");
            try {
                resolver = process(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else if (request.getMethod().equals("GET")) {
            System.out.println("From LoginController: iam Get");
            resolver = new ViewResolver(ResourcePathMapper.PAGE_LOGIN.getPath());
        }
        return resolver;
    }


    public ViewResolver process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ViewResolver resolver = new ViewResolver();
        String email = (String) req.getParameter("email");
        String password = (String) req.getParameter("password");
        CustomerDTO customerDTO = CustomerService.findUserByEmail(email);
        boolean correctPassword = PasswordHashing.checkPassword(password, customerDTO.getPassword());
        System.out.println("From LoginController: " + customerDTO.toString());
        if(customerDTO != null && correctPassword ){
            HttpSession session = req.getSession(true);
            session.setAttribute("currentUser", customerDTO);
            if (customerDTO.getEmail().equals("ee")) {
                System.out.println("ANA ADMIN");
                resolver.forward(ResourcePathMapper.PAGE_ADMIN.getPath());
            } else {
                resolver.forward(ResourcePathMapper.PAGE_HOME.getPath());
            }
        }else {
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write("{ \"loginfailed\": " + true + " }");
        }
        return resolver;
    }
}
