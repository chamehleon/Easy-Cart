package com.ecommerce.Persistence.DAOs.Implementations;

import com.ecommerce.Persistence.DAOs.GenericDAOs.GenericDAOImpl;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Entities.Product;

public class ProductDAO extends GenericDAOImpl<Product> {
    public ProductDAO() {
        super(Product.class);
    }



}
