package com.ecommerce.Persistence.DTOs;

import lombok.ToString;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.ecommerce.Persistence.Entities.OrdersItemId;
import com.ecommerce.Persistence.Entities.Product;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

/**
 * DTO for {@link com.ecommerce.Persistence.Entities.Customer}
 */
@Value
@ToString
public class OrdersItemDTO implements Serializable {
  
    private OrdersItemId id;

    private Integer productId;
    private String productName;
    private BigDecimal productPrice;


    private Integer quantity;
    private BigDecimal amount;
    

  

}