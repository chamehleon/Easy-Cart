package com.ecommerce.Persistence.DTOs;

import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link com.ecommerce.Persistence.Entities.Customer}
 */

@Data
public class CustomerDTO implements Serializable {
    Integer id;
    String customerName;
    LocalDate birthday;
    String password;
    String job;
    String email;
    BigDecimal creditLimit;
    String city;
    String country;
    String streetNo;
    String streetName;
    String interests;


}