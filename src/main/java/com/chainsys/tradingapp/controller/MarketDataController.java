package com.chainsys.tradingapp.controller;

import com.chainsys.tradingapp.service.MarketDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketDataController {

    @Autowired
    private MarketDataService marketDataService;

    @GetMapping("/market/nse")
    public String getNSEMarketData() {

        return marketDataService.getNSEMarketData();
    }
}