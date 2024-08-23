package com.example.stockprice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.stockprice.model.Stock;

@Service
public class SecurityConfig {

    @Value("${alphavantage.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public SecurityConfig(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("stocks")
    public Stock getStockPrice(String symbol) {
        String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + apiKey;
        try {
            Stock stock = restTemplate.getForObject(url, Stock.class);
            if (stock == null) {
                throw new RuntimeException("No data found for symbol: " + symbol);
            }
            return stock;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching stock price for symbol: " + symbol, e);
        }
    }
}
