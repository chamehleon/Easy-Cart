package com.ecommerce.Persistence.DAOs.GenericDAOs;


import java.util.List;

public interface GenericDAOInt<T,ID>{
    public List<T> findAll();
    public T findById(ID id);
    public void create(T entity);
    public T update(T entity);
    public void deleteById(ID id);
    public void delete(T entity);
}

//public interface DAO <T>{
//
//    boolean insert(T entity);
//    T get(int key);
//    void update(T entity);
//    void delete(T entity);
//}