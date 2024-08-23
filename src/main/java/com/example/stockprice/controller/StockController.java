package com.example.stockprice.controller;

import com.example.stockprice.model.Stock;
import com.example.stockprice.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping("/{symbol}")
    public Stock getStock(@PathVariable String symbol) {
        return stockService.getStockPrice(symbol);  
    }
}
