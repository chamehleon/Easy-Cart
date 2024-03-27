package com.ecommerce.Controllers;

import com.ecommerce.Controllers.FrontController.IController;
import com.ecommerce.Controllers.FrontController.ViewResolver;
//import com.ecommerce.Services.RegisterService;
import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Persistence.DTOs.OrderDTO;
import com.ecommerce.Persistence.DTOs.OrdersItemDTO;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Entities.Order;
import com.ecommerce.Persistence.Entities.OrdersItem;
import com.ecommerce.Persistence.Mappers.OrdersWithItemsMapper;
import com.ecommerce.Services.CustomerService;
import com.ecommerce.Services.OrderService;
import com.ecommerce.Utils.PasswordHashing;
import com.ecommerce.Utils.ResourcePathMapper;
import com.google.gson.Gson;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;

import org.mapstruct.factory.Mappers;

public class UserOrdersController implements IController {
    private static UserOrdersController instance;

    private UserOrdersController() {
    }

    public static UserOrdersController getInstance() {
        if (instance == null) {
            instance = new UserOrdersController();
        }
        return instance;
    }

    @Override
    public ViewResolver resolve(final HttpServletRequest req, final HttpServletResponse response) {

        System.out.println("start");
        ViewResolver resolver = new ViewResolver();
        int page  = Integer.parseInt(req.getParameter("page"));
        CustomerDTO customer = (CustomerDTO) req.getSession().getAttribute("currentUser");
        ArrayList<Order> orders = CustomerService.getUserOrders(customer , page);
       
        Map<Order , List<OrdersItem>> map = OrderService.getAllOrderItems(orders);
       System.out.println("middle");
       System.out.println("map size is : " + map.size());


        System.out.println("end");


        // Convert object to JSON stringe

        
        OrdersWithItemsMapper maptoDto = Mappers.getMapper(OrdersWithItemsMapper.class);
        Map<OrderDTO, List<OrdersItemDTO>> dtoMap = maptoDto.mapEntitiesToDTOs(map);

        

        Gson gson = new Gson();

        // Convert the Java object to JSON
        String json = gson.toJson(dtoMap);
        System.out.println(json);

            resolver.JSON(json);
        return resolver;
    }
}
