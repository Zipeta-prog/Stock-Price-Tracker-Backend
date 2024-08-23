package com.example.stockprice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class StockService implements StockInterface {
	@Value("${api.key}")
    private String apiKey;

    @Cacheable("stocks")
    @Override
    public String getStockPrice(String symbol) {
        String url = "https://api.example.com/stock/" + symbol + "?apikey=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
