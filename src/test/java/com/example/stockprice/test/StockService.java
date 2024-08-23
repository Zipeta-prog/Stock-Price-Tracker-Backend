package com.example.stockprice.test;

import com.example.stockprice.model.Stock;
import com.example.stockprice.service.StockService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class StockServiceTest {

    private StockService stockService;

    @BeforeEach
    void setUp() {
        RestTemplate restTemplate = new RestTemplate();
        stockService = new StockService(restTemplate);
    }

    @Test
    void testGetStockPriceReturnsStockObject() {
        String testSymbol = "IBM";

        Stock stock = stockService.getStockPrice(testSymbol);

        assertNotNull(stock);
        assertEquals(testSymbol, stock.getSymbol());
        assertTrue(stock.getPrice() > 0);
    }

    @Test
    void testGetStockPriceThrowsExceptionForInvalidSymbol() {
        String invalidSymbol = "INVALID";

        Exception exception = assertThrows(RuntimeException.class, () -> {
            stockService.getStockPrice(invalidSymbol);
        });

        String expectedMessage = "Error fetching stock price for symbol";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}

