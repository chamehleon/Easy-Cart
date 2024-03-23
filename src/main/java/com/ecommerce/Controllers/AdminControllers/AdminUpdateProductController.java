package com.ecommerce.Controllers.AdminControllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.Entities.Category;
import com.ecommerce.Persistence.Entities.Product;
import com.ecommerce.Persistence.Entities.ProductImage;
import com.ecommerce.Services.CategoryService;
import com.ecommerce.Services.ProductService;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AdminUpdateProductController implements IController {
    private static AdminUpdateProductController instance;

    private AdminUpdateProductController() {
    }

    public static AdminUpdateProductController getInstance() {
        if (instance == null) {
            instance = new AdminUpdateProductController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        try {
            String method = request.getMethod();
            if (method.equals("GET")) {
                System.out.println("me here");
                int productId = Integer.parseInt(request.getParameter("id"));
                Optional<Product> optionalProducts = ProductService.getProductById(productId);
                Product product = optionalProducts.orElse(null);
                request.setAttribute("product", product);
                Optional<List<Category>> optionalCategories = CategoryService.getAllCategories();
                List<Category> categories = optionalCategories.orElse(Collections.emptyList());
                request.setAttribute("categories", categories);
                resolver.forward(ResourcePathMapper.PAGE_ADMIN_VIEW_PRODUCT.getPath());

            } else if (method.equals("POST")) {
                System.out.println("hello admin post update");
                String productId = request.getParameter("id");
                String productName = request.getParameter("productName");
                String productDescription = request.getParameter("productDescription");
                String productPrice = request.getParameter("productPrice");
                String productQuantity = request.getParameter("stockQuantity");
                String productCategory = request.getParameter("productCategory");



                Category category = CategoryService.getCategoryById(Integer.parseInt(productCategory)).get();

                Product product = ProductService.getProductById(Integer.parseInt(productId)).get();
                product.setProductName(productName);
                product.setProductDescription(productDescription);
                product.setProductPrice(new BigDecimal(productPrice));
                product.setStockQuantity(Integer.parseInt(productQuantity));
                product.setCategory(category);

                List<ProductImage> productImages = product.getProductImages();


                productImages.get(0).setImageUrl((String) request.getParameter("image1"));
                productImages.get(1).setImageUrl((String) request.getParameter("image2"));
                productImages.get(2).setImageUrl((String) request.getParameter("image3"));

                ProductService.updateProduct(product);

                resolver.redirect(ResourcePathMapper.ADMIN_PRODUCT_CONTROLLER.getPath());





            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resolver;
    }


}
