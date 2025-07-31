package com.park0587.orderhandler.DataObjects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="order_product")
@Getter
@Setter
public class OrderProduct {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="order_product_id")
    private long id;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    /* @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="productId", nullable=false) */
    @Column(name="product_id", nullable=false)
    private int productId;

    @Column(name="quantity", nullable=false)
    private int quantity;

    @Column(name="price_at_purchase", nullable=false)
    private double priceAtPurchase;
}
