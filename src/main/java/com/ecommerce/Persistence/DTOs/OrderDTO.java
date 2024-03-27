package com.ecommerce.Persistence.DTOs;

import lombok.ToString;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.ecommerce.Persistence.Entities.Customer;
import com.ecommerce.Persistence.Entities.OrdersItem;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * DTO for {@link com.ecommerce.Persistence.Entities.Customer}
 */
@Value
@ToString
public class OrderDTO implements Serializable {
 
    private Integer id;
    private Date orderedAt;


}