package com.ecommerce.Persistence.DTOs;

import lombok.Value;

import java.math.BigDecimal;

@Value
public class ProductDTO {

    private Integer id;
    private String productName;
    private Integer stockQuantity;
    private String productDescription;
    private BigDecimal productPrice;

}
