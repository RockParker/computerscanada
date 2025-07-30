package com.park0587.orderhandler.RestControllers;

import com.park0587.orderhandler.DataObjects.ProductDto;
import com.park0587.orderhandler.Feign.InventoryClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stock")
public class StockInformationController {

    private final InventoryClient inventoryClient;

    public StockInformationController(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    @GetMapping("/{productId}")
    public ProductDto getStockInfo(@PathVariable Long productId) {
        return inventoryClient.getProductById(productId);
    }
}

