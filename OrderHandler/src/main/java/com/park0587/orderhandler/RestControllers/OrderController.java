package com.park0587.orderhandler.RestControllers;

import com.park0587.orderhandler.DataObjects.Order;
import com.park0587.orderhandler.DataObjects.OrderProduct;
import com.park0587.orderhandler.Repositories.CustomerRepository;
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
    @Autowired
    private CustomerRepository customerRepository;

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

        var customer = customerRepository.findById(order.getCustomer().getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setCustomer(customer); // set the customer reference

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

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable long id, @RequestBody Order order) {
        if (!orderRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        var existingOrder = orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        existingOrder.setOrderStatus(order.getOrderStatus());

        return ResponseEntity.ok(orderRepo.save(existingOrder));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable long id) {
        if (!orderRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        orderRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
