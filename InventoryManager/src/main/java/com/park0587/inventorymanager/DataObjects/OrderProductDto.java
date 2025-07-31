package com.park0587.inventorymanager.DataObjects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="order_product")
@Getter
@Setter
public class OrderProductDto {

    @Id
    @Column(name="order_product_id")
    private long orderProductId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="product_id")
    private Product product;
}
