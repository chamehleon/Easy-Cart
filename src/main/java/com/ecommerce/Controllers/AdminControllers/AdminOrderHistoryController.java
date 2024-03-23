package com.ecommerce.Controllers.AdminControllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Entities.Order;
import com.ecommerce.Services.CustomerService;
import com.ecommerce.Services.OrderService;
import com.ecommerce.Utils.ResourcePathMapper;
import jakarta.servlet.http.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdminOrderHistoryController implements IController {
    private static AdminOrderHistoryController instance;

    private AdminOrderHistoryController() {
    }

    public static AdminOrderHistoryController getInstance() {
        if (instance == null) {
            instance = new AdminOrderHistoryController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(HttpServletRequest request, HttpServletResponse response) {
        ViewResolver resolver = new ViewResolver();
        try {
            String method = request.getMethod();
            if (method.equals("GET")) {
                int customerId = Integer.parseInt(request.getParameter("customerId"));
                Optional<Customer> customer = CustomerService.getCustomerById(customerId);
                Optional<List<Order>> orders = OrderService.getOrdersByCustomerId(customerId);
                if (orders.isPresent()) {
                    List<BigDecimal> orderTotals = orders.get().stream()
                            .map(order -> OrderService.getOrderTotal(order.getId()))
                            .collect(Collectors.toList());
                    request.setAttribute("orderTotals", orderTotals);
                }
                request.setAttribute("orders", orders.orElse(null));
                request.setAttribute("customer", customer.orElse(null));



                resolver.forward(ResourcePathMapper.PAGE_ADMIN_ORDER_HISTORY.getPath());
            } else if (method.equals("POST")) {
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }
        return resolver;
    }
}
