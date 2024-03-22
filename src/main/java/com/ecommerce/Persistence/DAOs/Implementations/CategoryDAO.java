package com.ecommerce.Persistence.DAOs.Implementations;

import com.ecommerce.Persistence.DAOs.GenericDAOs.GenericDAOImpl;
import com.ecommerce.Persistence.Entities.Category;
import com.ecommerce.Persistence.Entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public class CategoryDAO extends GenericDAOImpl<Category> {

    public CategoryDAO() {
        super(Category.class);
    }

    public Optional<Category> findByName(String categoryName, EntityManager em) {
        TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c WHERE c.categoryName = :name", Category.class);
        query.setParameter("name", categoryName);
        Category category = query.getSingleResult();
        return Optional.ofNullable(category);


    }
}
