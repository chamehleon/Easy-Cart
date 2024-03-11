package com.ecommerce.Services;

//import com.ecommerce.Persistence.DAOs.Implementations.CustomerDAOImpl;
import com.ecommerce.Persistence.DAOs.Implementations.CustomerDAOImpl;
import com.ecommerce.Persistence.DAOs.Interfaces.CustomerDAO;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Persistence.Entities.Customer;
//import com.ecommerce.Persistence.Mappers.CustomerMapper;
import com.ecommerce.Persistence.Mappers.CustomerMapper;
import com.ecommerce.Utils.EntityManagerThreadLocalUtil;
import com.ecommerce.Utils.PasswordHashing;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mapstruct.factory.Mappers;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

public class RegisterService {
    CustomerDAO customerDAO;
    private final CustomerMapper customerMapper;
    EntityManager entityManager ;

    public  RegisterService (){
       customerDAO = new CustomerDAOImpl();
       customerMapper = Mappers.getMapper(CustomerMapper.class);

   }
    public boolean registerUser(CustomerDTO customerDTO){

        entityManager = EntityManagerThreadLocalUtil.getEntityManager();
        String hashedPassword = PasswordHashing.hashPassword(customerDTO.getPassword());
        customerDTO.setPassword(hashedPassword);

        // Convert the CustomerDTO to a Customer entity
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);

        // Save the Customer entity to the database
        return customerDAO.insert(customer, entityManager);

//        if(createdCustomer != null){
////            HttpSession session = req.getSession(true);
////            session.setAttribute("currentCustomer", createdCustomer);
////            resp.sendRedirect(ResourcePathMapper.PAGE_HOME.getPath());
////        }else {
////            req.setAttribute("signupFailed", true);
////            resp.sendRedirect(ResourcePathMapper.PAGE_ERROR.getPath());
////        }

    }


}
