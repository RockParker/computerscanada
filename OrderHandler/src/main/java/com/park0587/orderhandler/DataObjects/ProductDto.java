package com.park0587.orderhandler.DataObjects;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto
{
    private long productId;

    private String name;

    private String brand;

    private String category;

    private double price;

    private int quantity;
}
