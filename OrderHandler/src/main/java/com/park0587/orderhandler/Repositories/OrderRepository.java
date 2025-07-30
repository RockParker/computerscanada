package com.park0587.orderhandler.Repositories;

import com.park0587.orderhandler.DataObjects.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
