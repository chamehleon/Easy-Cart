package com.ecommerce.Persistence.DTOs;

import lombok.Data;
import lombok.Setter;
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
    public CustomerDTO(String customerName, LocalDate birthday, String password, String job, String email, BigDecimal creditLimit, String city, String country, String streetNo, String streetName, String interests) {
        this.customerName = customerName;
        this.birthday = birthday;
        this.password = password;
        this.job = job;
        this.email = email;
        this.creditLimit = creditLimit;
        this.city = city;
        this.country = country;
        this.streetNo = streetNo;
        this.streetName = streetName;
        this.interests = interests;
    }
    public CustomerDTO(String customerName, String password, String email) {
        this.customerName = customerName;
        this.password = password;
        this.email = email;
        this.birthday = LocalDate.now();
        this.job = "none";
        this.creditLimit = new BigDecimal("4440.00");
        this.city = "none";
        this.country = "none";
        this.streetNo = "none";
        this.streetName = "none";
        this.interests = "none";

    }

}

