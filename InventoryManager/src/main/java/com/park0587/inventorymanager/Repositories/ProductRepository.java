package com.park0587.inventorymanager.Repositories;


import com.park0587.inventorymanager.DataObjects.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
