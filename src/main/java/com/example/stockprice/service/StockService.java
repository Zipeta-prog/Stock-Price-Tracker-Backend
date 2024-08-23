package com.example.stockprice.service;

import com.example.stockprice.model.Stock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockService {

    @Value("${alphavantage.apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public StockService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("stocks")
    public Stock getStockPrice(String symbol) {
        String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbol + "&apikey=" + apiKey;
        // Assuming the API returns a JSON structure compatible with the Stock class
        return restTemplate.getForObject(url, Stock.class);  // Return Stock object
    }
}
