package com.ecommerce.Persistence.DAOs.GenericDAOs;


import jakarta.persistence.EntityManager;

import java.util.List;

public interface GenericDAOInt<T>{
    public List<T> findAll(EntityManager em);
    public T findById(int id, EntityManager em);
    public boolean create(T entity, EntityManager em);
    public T update(T entity, EntityManager em);
    public void deleteById(int id, EntityManager em);
    public void delete(T entity, EntityManager em);
}

//public interface DAO <T>{
//
//    boolean insert(T entity);
//    T get(int key);
//    void update(T entity);
//    void delete(T entity);
//}