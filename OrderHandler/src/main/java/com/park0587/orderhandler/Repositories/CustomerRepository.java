package com.park0587.orderhandler.Repositories;

import com.park0587.orderhandler.DataObjects.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
