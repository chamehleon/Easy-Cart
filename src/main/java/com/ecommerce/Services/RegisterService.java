package com.ecommerce.Services;

import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RegisterService extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String job = req.getParameter("job");
        String country = req.getParameter("country");
        String city = req.getParameter("city");
        String streetNo = req.getParameter("streetNo");
        String streetName = req.getParameter("streetName");
        BigDecimal credit = new BigDecimal(req.getParameter("credit"));
        LocalDate birthdate = LocalDate.parse(req.getParameter("birthdate"));

        Customer customer = new Customer(
                username, birthdate, password, job, email, credit, city, country, streetNo, streetName, "none");

        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(password, salt);


//        if(createdCustomer != null){
//            HttpSession session = req.getSession(true);
//            session.setAttribute("currentCustomer", createdCustomer);
//            resp.sendRedirect(ResourcePathMapper.PAGE_HOME.getPath());
//        }else {
//            req.setAttribute("signupFailed", true);
//            resp.sendRedirect(ResourcePathMapper.PAGE_ERROR.getPath());
//        }
    }

}
