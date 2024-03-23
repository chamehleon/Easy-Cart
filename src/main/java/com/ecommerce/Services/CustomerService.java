package com.ecommerce.Services;

import com.ecommerce.Persistence.DAOs.Implementations.CustomerDAO;
import com.ecommerce.Persistence.DAOs.Implementations.ProductDAO;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Mappers.CustomerMapper;
import com.ecommerce.Utils.JpaTransactionManager;

import java.util.List;
import java.util.Optional;

public class CustomerService {

    public static boolean register(Customer customer) {
        CustomerDAO customerDAO = new CustomerDAO();
        //Customer customer = CustomerMapper.INSTANCE.toEntity(customerDTO);
        boolean isRegistered = JpaTransactionManager.doInTransaction(em -> customerDAO.create(customer, em));
        return isRegistered;
    }

    public static CustomerDTO findUserByEmail(String email) {
        CustomerDAO customerDAO = new CustomerDAO();
        Optional<Customer> customer = JpaTransactionManager.doInTransaction(em -> customerDAO.findUserByEmail(email, em));
        return customer.map(CustomerMapper.INSTANCE::toDto).orElseThrow(() -> new RuntimeException("From LoginService: Customer not found"));
    }

    public static boolean isUserExists(String email) {
        CustomerDAO customerDAO = new CustomerDAO();
        Optional<Customer> customer = JpaTransactionManager.doInTransaction(em -> customerDAO.findUserByEmail(email, em));
        return customer.isPresent();
    }
    // get all custoemrs
    public static Optional<List<Customer>> getAllCustomers() {
        return Optional.ofNullable(JpaTransactionManager.doInTransaction(em -> {
            CustomerDAO customerDAO = new CustomerDAO();
            return customerDAO.findAll(em);
        }));
    }
    // get customer by id
    public static Optional<Customer> getCustomerById(int customerId) {
        return Optional.ofNullable(JpaTransactionManager.doInTransaction(em -> {
            CustomerDAO customerDAO = new CustomerDAO();
            return customerDAO.findById(customerId, em);
        }));
    }
}
