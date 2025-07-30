package com.park0587.orderhandler.RestControllers;

import com.park0587.orderhandler.DataObjects.Order;
import com.park0587.orderhandler.DataObjects.OrderProduct;
import com.park0587.orderhandler.Repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepo;

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        // Optional: set timestamps or total
        order.setOrderDate(Date.from(Instant.now()));

        double total = 0.0d;
        for (OrderProduct item : order.getOrderProducts()) {
            item.setOrder(order); // link back reference

            double itemTotal = item.getPriceAtPurchase() * item.getQuantity();
            total += itemTotal;
        }
        order.setTotalAmount(total);

        Order saved = orderRepo.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return orderRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
