package com.ecommerce.Persistence.DAOs.Implementations;

import com.ecommerce.Persistence.DAOs.Interfaces.CustomerDAO;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.PersistenceManager;
import jakarta.persistence.EntityManager;

public class CustomerDAOImpl implements CustomerDAO {

    public static EntityManager entityManager = PersistenceManager.getEntityManager();
    @Override
    public boolean insert(Customer entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Customer get(int key) {
        Customer customer = null;
        try {
            customer = entityManager.find(Customer.class, key);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void update(Customer entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Customer entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (RuntimeException e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

}
