package com.park0587.orderhandler.Feign;

import com.park0587.orderhandler.DataObjects.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-manager")
public interface InventoryClient {

    @GetMapping("/api/inventory/{productId}")
    ProductDto getProductById(@PathVariable("productId") Long productId);
}
