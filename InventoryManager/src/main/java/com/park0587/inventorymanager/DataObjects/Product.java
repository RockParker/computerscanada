package com.park0587.inventorymanager.DataObjects;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="product")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long productId;

    @Column(name="name", nullable=false, length = 50)
    private String name;

    @Column(name="brand", length = 50)
    private String brand;

    @Column(name="category", length = 50)
    private String category;

    @Column(name="price", nullable=false)
    private double price;

    @Column(name="quantity_in_stock", nullable=false)
    private int quantity;

/*    @JsonIgnore
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderProductDto> orderProducts;*/
}
