package com.ecommerce.Persistence.DAOs.Interfaces;

public interface DAO <T>{
    boolean insert(T entity);
    T get(int key);
    void update(T entity);
    void delete(T entity);
}
