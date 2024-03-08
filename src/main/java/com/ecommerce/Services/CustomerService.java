package com.ecommerce.Services;

import com.ecommerce.Persistence.DAOs.Implementations.CustomerDAOImpl;
import com.ecommerce.Persistence.DAOs.Interfaces.DAO;
import com.ecommerce.Persistence.Entities.Customer;

public class CustomerService {
    DAO<Customer> customerDAO = new CustomerDAOImpl();
    public boolean register(Customer customer) {
        return customerDAO.insert(customer);
    }
}
