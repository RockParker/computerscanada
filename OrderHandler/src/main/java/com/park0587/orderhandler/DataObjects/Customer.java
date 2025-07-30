package com.park0587.orderhandler.DataObjects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Table(name="customer")
@Getter @Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long customerId;

    @Column(name="name", length = 50)
    private String name;

    @Column(name="email", length = 100)
    private String email;

    @Column(name="phone", length=10)
    private String phone;

    @Column(name="shipping_address", length = 255)
    private String shippingAddress;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders;
}