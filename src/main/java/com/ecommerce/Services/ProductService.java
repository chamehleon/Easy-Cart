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

    public static Product getProducttById(int productId){
        return JpaTransactionManager.doInTransaction(em -> {
            ProductDAO productDAO = new ProductDAO();
            return productDAO.findById(productId, em);
        });
    }

    public static Optional<Product> getProductById(int productId){
        return JpaTransactionManager.doInTransaction(em -> {
            ProductDAO productDAO = new ProductDAO();
            Optional<Product> product = Optional.ofNullable(productDAO.findById(productId, em));
            return product;
        });
    }

    public static boolean sufficientQuantity(Integer  productId){

        return JpaTransactionManager.doInTransaction(em->{
            ProductDAO productDAO = new ProductDAO();
            Product product=productDAO.findById(productId, em);
            if(product.getStockQuantity() >= 1)
                return true;
            else
                return false;
        });

    }
    // create a new product
    public static Boolean createProduct(Product product){
        return JpaTransactionManager.doInTransaction(em -> {
            ProductDAO productDAO = new ProductDAO();
            return productDAO.create(product, em);
        });
    }

    // update product details
    public static Optional<Product> updateProduct(Product product){
        return Optional.ofNullable(JpaTransactionManager.doInTransaction(em -> {
            ProductDAO productDAO = new ProductDAO();
            return productDAO.update(product, em);
        }));
    }


}
