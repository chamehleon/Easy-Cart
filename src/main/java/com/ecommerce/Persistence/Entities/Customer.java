package com.ecommerce.Persistence.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "customer", schema = "ecommerce")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @Column(name = "customer_name", nullable = false)
    private String customerName;

    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "job", nullable = false)
    private String job;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "credit_limit", precision = 15, scale = 2)
    private BigDecimal creditLimit;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "street_no", nullable = false)
    private String streetNo;

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "interests", nullable = false)
    private String interests;

    @OneToOne(mappedBy = "customer")
    private Cart cart;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders = new LinkedHashSet<>();

    public Customer(String customerName, LocalDate birthday, String password, String job, String email, BigDecimal creditLimit, String city, String country, String streetNo, String streetName, String interests) {
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
    public Customer(String customerName, String password, String email) {
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