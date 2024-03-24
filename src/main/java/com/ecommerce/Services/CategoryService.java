package com.ecommerce.Services;

import com.ecommerce.Persistence.DAOs.Implementations.CategoryDAO;
import com.ecommerce.Persistence.Entities.Category;
import com.ecommerce.Utils.JpaTransactionManager;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CategoryService {
    //  i want to get the category by name

    public static Optional<Category> getCategoryByName(String categoryName) {
        return JpaTransactionManager.doInTransaction(em -> {
            CategoryDAO categoryDAO = new CategoryDAO();
            return categoryDAO.findByName(categoryName, em);
        });
    }
    // i want to get the category by id
    public static Optional<Category> getCategoryById(int categoryId) {
        return JpaTransactionManager.doInTransaction(em -> {
            CategoryDAO categoryDAO = new CategoryDAO();
            return Optional.ofNullable(categoryDAO.findById(categoryId, em));
        });
    }

    public static Optional<List<Category>> getAllCategories() {
        return Optional.ofNullable(JpaTransactionManager.doInTransaction(em -> {
            CategoryDAO categoryDAO = new CategoryDAO();
            return categoryDAO.findAll(em);
        }));
    }




}
