package com.ecommerce.Persistence.Mappers;

import com.ecommerce.Persistence.DTOs.CustomerDTO;
import com.ecommerce.Persistence.DTOs.OrderDTO;
import com.ecommerce.Persistence.DTOs.OrdersItemDTO;
import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Entities.Order;
import com.ecommerce.Persistence.Entities.OrdersItem;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrdersWithItemsMapper {

    OrdersWithItemsMapper INSTANCE = Mappers.getMapper(OrdersWithItemsMapper.class);

   
    OrderDTO entityAToDTOA(Order entityA);


    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.productName", target = "productName")
    @Mapping(source = "product.productPrice", target = "productPrice")
    OrdersItemDTO entityBToDTOB(OrdersItem entityB);

        
    default Map<OrderDTO, List<OrdersItemDTO>> mapEntitiesToDTOs(Map<Order, List<OrdersItem>> entities) {
        Map<OrderDTO, List<OrdersItemDTO>> dtos = new LinkedHashMap();
        for (Map.Entry<Order, List<OrdersItem>> entry : entities.entrySet()) {
            OrderDTO dtoA = entityAToDTOA(entry.getKey());
            List<OrdersItemDTO> dtoBs = entry.getValue().stream()
                                        .map(this::entityBToDTOB)
                                        .collect(Collectors.toList());
            dtos.put(dtoA, dtoBs);
        }
        return dtos;
    }

}