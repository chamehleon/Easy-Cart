package com.ecommerce.Controllers.AdminControllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.Entities.Category;
import com.ecommerce.Persistence.Entities.Product;
import com.ecommerce.Persistence.Entities.ProductImage;
import com.ecommerce.Services.CategoryService;
import com.ecommerce.Services.ProductService;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class AdminAddProductController implements IController {
    private static AdminAddProductController instance;

    private AdminAddProductController() {
    }

    public static AdminAddProductController getInstance() {
        if (instance == null) {
            instance = new AdminAddProductController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        try {
            String method = request.getMethod();
            if (method.equals("GET")) {
                Optional<List<Category>> optionalCategories = CategoryService.getAllCategories();
                List<Category> categories = optionalCategories.orElse(Collections.emptyList());
                request.setAttribute("categories", categories);

                resolver.forward(ResourcePathMapper.PAGE_ADMIN_ADD_PRODUCT.getPath());
            } else if (method.equals("POST")) {
                String productName = (String) request.getParameter("name");
                String description = (String) request.getParameter("description");
                String productPrice = (String) request.getParameter("price");
                String category = (String) request.getParameter("category");
                String stock = (String) request.getParameter("stock");
                System.out.println(productName);
                System.out.println(description);
                System.out.println(productPrice);
                System.out.println(category);
                System.out.println(stock);


                Optional<Category> category1 = CategoryService.getCategoryById(Integer.parseInt(category));


                Product product = new Product();
                product.setProductName(productName);
                product.setProductDescription(description);
                product.setProductPrice(new BigDecimal(productPrice));
                product.setCategory(category1.get());
                product.setStockQuantity(Integer.parseInt(stock));

                product.addProductImage((String) request.getParameter("image1"));
                product.addProductImage((String) request.getParameter("image2"));
                product.addProductImage((String) request.getParameter("image3"));


                ProductService.createProduct(product);



                resolver.redirect(ResourcePathMapper.ADMIN_PRODUCT_CONTROLLER.getPath());






            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return resolver;
    }
//    private void addProductImage(Product product, String imageUrl) {
//        ProductImage productImage = new ProductImage();
//        productImage.setImageUrl(imageUrl);
//        productImage.setProduct(product);
//        product.getProductImages().add(productImage);
//    }
}
