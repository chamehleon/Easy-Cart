//package com.ecommerce;
//
//import com.ecommerce.Persistence.DAOs.Implementations.CustomerDAOImpl;
//import com.ecommerce.Persistence.Entities.Customer;
//import com.ecommerce.Persistence.PersistenceManager;
//import jakarta.persistence.EntityManager;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//
//public class Main {
//    public static void main(String[] args) {
//        EntityManager entityManager = PersistenceManager.getEntityManager();
//        entityManager.getTransaction().begin();
//        CustomerDAOImpl customerDAO = new CustomerDAOImpl();
//        // create customer and persist it
//         Customer customer = new Customer();
////         customer.setCustomerName("John Doe");
////            customer.setBirthday(LocalDate.of(1990, 1, 1));
////            customer.setPassword("password");
////            customer.setJob("Software Developer");
////            customer.setEmail("eee");
////            customer.setCreditLimit(new BigDecimal(1000));
////            customer.setCity("New York");
////            customer.setCountry("USA");
////            customer.setStreetNo("123");
////            customer.setStreetName("Main Street");
////            customer.setInterests("Sports, Music");
////          //  customerDAO.insert(customer);
////            customer.toString();
//        customer = customerDAO.get(2);
//        System.out.println(customer.toString());
//
//
//    }
//}
