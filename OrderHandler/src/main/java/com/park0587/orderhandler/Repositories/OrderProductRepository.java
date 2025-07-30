package com.park0587.orderhandler.Repositories;

import com.park0587.orderhandler.DataObjects.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
}