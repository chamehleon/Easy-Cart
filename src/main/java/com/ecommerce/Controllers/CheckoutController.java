//package com.ecommerce.Controllers;
//
//import com.ecommerce.Controllers.FrontController.IController;
//import com.ecommerce.Controllers.FrontController.ViewResolver;
//import com.ecommerce.Persistence.Entities.Cart;
//import com.ecommerce.Persistence.Entities.CartItem;
//import com.ecommerce.Persistence.Entities.Customer;
//import com.ecommerce.Persistence.Entities.Product;
//import com.ecommerce.Services.CartService;
//import com.ecommerce.Services.OrderService;
//import com.ecommerce.Utils.ResourcePathMapper;
//import com.google.gson.Gson;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import java.io.BufferedReader;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
//public class CheckoutController implements IController {
//    private static CheckoutController instance;
//
//    private CheckoutController() {
//    }
//
//    public static CheckoutController getInstance() {
//        if (instance == null) {
//            instance = new CheckoutController();
//        }
//        return instance;
//    }
//
//    @Override
//    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
//        ViewResolver resolver = new ViewResolver();
//        if (request.getMethod().equals("GET")) {
//            System.out.println("Checkout controller GET");
//            // resolver.forward(ResourcePathMapper.PAGE_CART.getPath());
//        } else if (request.getMethod().equals("POST")) {
//            System.out.println("Checkout controller POST");
//            HttpSession session = request.getSession(false);
//            if (session == null || session.getAttribute("currentUser") == null) {
//                System.out.println("User not logged in");
//                resolver.forward(ResourcePathMapper.PAGE_LOGIN.getPath());
//            } else {
//                System.out.println("User logged in");
//                try {
//                    // Read JSON data from request body
//                    BufferedReader reader = request.getReader();
//                    StringBuilder sb = new StringBuilder();
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        sb.append(line);
//                    }
//                    String jsonData = sb.toString();
//                    System.out.println("Received JSON data: " + jsonData);
//
//                    // Convert JSON data to array of ProductCheckoutDTO objects using Gson
//                    Gson gson = new Gson();
//                    ProductCheckoutDTO[] productDataArray = gson.fromJson(jsonData, ProductCheckoutDTO[].class);
//                    for (ProductCheckoutDTO productData : productDataArray) {
//                        System.out.println(productData.toString());
//                    }
//                    // Convert ProductCheckoutDTO objects to CartItem objects
//                    List<CartItem> cartItemList = new ArrayList<>();
//                    Customer customer = new Customer();
//                    if (session.getAttribute("currentUser") != null) {
//                         // infinite loop hena!
//                         customer = (Customer) session.getAttribute("currentUser");
//                    }
//                    System.out.println(customer.getEmail());
//                    Integer customerId = customer.getId();
//                    Cart cart = CartService.getCartByCustomerId(customerId);
//
//
//                    for (ProductCheckoutDTO productData : productDataArray) {
//                        CartItem cartItem = new CartItem();
//                        Product product = new Product();
//                        product.setId(Integer.parseInt(productData.getProductId()));
//                        product.setProductName(productData.getName());
//                        product.setProductPrice(new BigDecimal(productData.getPrice()));
//                        product.setProductDescription(productData.getDescription());
//                        cartItem.setProduct(product);
//                        cartItem.setQuantity(productData.getQuantity());
//                        cartItem.setCart(cart);
//                        cartItem.setAmount(new BigDecimal(productData.getPrice()).multiply(new BigDecimal(productData.getQuantity())));
//                        cartItemList.add(cartItem);
//                    }
//                    for (CartItem productData : cartItemList) {
//                        System.out.println("ew3a "+productData.toString());
//                    }
//                    // Create order from cart items
//                    boolean orderCreated = OrderService.createOrderFromCartItems(cartItemList);
//
//                    if (orderCreated) {
//                        System.out.println("Order created successfully");
//                        resolver.forward(ResourcePathMapper.PAGE_ABOUT.getPath());
//                    } else {
//                        System.out.println("Order creation failed");
//                        resolver.forward(ResourcePathMapper.PAGE_ORDER_ERROR.getPath());
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    System.out.println("Error reading JSON data from request body");
//                    resolver.forward(ResourcePathMapper.PAGE_ERROR.getPath());
//                }
//            }
//        }
//        return resolver;
//    }
//
//}
