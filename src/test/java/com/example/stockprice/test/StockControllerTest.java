package com.example.stockprice.test;

import com.example.stockprice.controller.StockController;
import com.example.stockprice.model.Stock;
import com.example.stockprice.service.StockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class StockControllerTest {

    private StockController stockController;

    @BeforeEach
    void setUp() {
        StockService stockService = new StockService(new RestTemplate());
        stockController = new StockController(stockService);
    }

    @Test
    void testGetStockReturnsCorrectStock() {
        String testSymbol = "AAPL";
        Stock stock = stockController.getStock(testSymbol);

        assertNotNull(stock);
        assertEquals(testSymbol, stock.getSymbol());
        assertTrue(stock.getPrice() > 0);
    }

    @Test
    void testGetStockThrowsExceptionForInvalidSymbol() {
        String invalidSymbol = "INVALID";

        Exception exception = assertThrows(RuntimeException.class, () -> {
            stockController.getStock(invalidSymbol);
        });

        String expectedMessage = "Error fetching stock price for symbol";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
