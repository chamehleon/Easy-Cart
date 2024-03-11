package com.ecommerce.Services;

import com.ecommerce.Persistence.DAOs.Implementations.CustomerDAO;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Mappers.CustomerMapper;
import com.ecommerce.Utils.JpaTransactionManager;

//public class RegisterService {
//    CustomerDAO customerDAO;
//    private final CustomerMapper customerMapper;
//    EntityManager entityManager ;
//
//    public  RegisterService (){
//       customerDAO = new CustomerDAOImpl();
//       customerMapper = Mappers.getMapper(CustomerMapper.class);
//
//   }
//    public boolean registerUser(CustomerDTO customerDTO){
//
//        entityManager = EntityManagerThreadLocalUtil.getEntityManager();
//        String hashedPassword = PasswordHashing.hashPassword(customerDTO.getPassword());
//        customerDTO.setPassword(hashedPassword);
//
//        // Convert the CustomerDTO to a Customer entity
//        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);
//
//        // Save the Customer entity to the database
//        return customerDAO.insert(customer, entityManager);
//
////        if(createdCustomer != null){
//////            HttpSession session = req.getSession(true);
//////            session.setAttribute("currentCustomer", createdCustomer);
//////            resp.sendRedirect(ResourcePathMapper.PAGE_HOME.getPath());
//////        }else {
//////            req.setAttribute("signupFailed", true);
//////            resp.sendRedirect(ResourcePathMapper.PAGE_ERROR.getPath());
//////        }
//
//    }


// here ya nadaaaaaaaaaaaaaaaa


public class RegisterService {

    public static boolean register(Customer customer) {
        CustomerDAO customerDAO = new CustomerDAO();
     //   Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);
        boolean isRegistered = JpaTransactionManager.doInTransaction(em -> customerDAO.create(customer, em));
        return isRegistered;
    }


}
