package com.ecommerce.Persistence.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductWithQuantityDto implements Serializable {

    int productId;
    String productName;
    BigDecimal productPrice;
    String productDescription;
    String productImage;
    Integer productQuantity;

}
