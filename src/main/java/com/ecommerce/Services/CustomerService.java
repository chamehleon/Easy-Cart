//package com.ecommerce.Services;
//
////import com.ecommerce.Persistence.DAOs.Implementations.CustomerDAOImpl;
//import com.ecommerce.Persistence.DAOs.Interfaces.DAO;
//import com.ecommerce.Persistence.DTOs.CustomerDTO;
//import com.ecommerce.Persistence.Entities.Customer;
//import com.ecommerce.Persistence.Mappers.CustomerMapper;
//import org.mapstruct.factory.Mappers;
//
//public class CustomerService {
//    private static CustomerService instance;
//    private DAO<Customer> customerDAO;
//    private final CustomerMapper customerMapper;
//
//    private CustomerService() {
//        //customerDAO = new CustomerDAOImpl();
//        customerMapper = Mappers.getMapper(CustomerMapper.class);
//    }
//
//    public static synchronized CustomerService getInstance() {
//        if (instance == null) {
//            instance = new CustomerService();
//        }
//        return instance;
//    }
//
//    public boolean register(CustomerDTO customerDTO) {
//        Customer customer = customerMapper.toEntity(customerDTO);
//        return customerDAO.insert(customer);
//    }
//}