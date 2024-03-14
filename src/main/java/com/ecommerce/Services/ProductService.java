package com.ecommerce.Services;

import com.ecommerce.Persistence.DAOs.Implementations.ProductDAO;
import com.ecommerce.Persistence.Entities.Product;
import com.ecommerce.Utils.JpaTransactionManager;

import java.util.List;
import java.util.Optional;

public class ProductService {
    public static Optional<List<Product>> getAllProducts(){
        return Optional.ofNullable(JpaTransactionManager.doInTransaction(em -> {
            ProductDAO productDAO = new ProductDAO();
            return productDAO.findAll(em);
        }));
    }
}
