package com.chainsys.tradingapp.controller;


import com.chainsys.tradingapp.model.Stock;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class TopStocksController {

    private final Random random =
            new Random();

    @GetMapping("/topstocks")
    public String showTopStocks(Model model) {

        List<Stock> topBuyStocks =
                new ArrayList<>();

        List<Stock> topSellStocks =
                new ArrayList<>();

        List<Stock> mostTradedStocks =
                new ArrayList<>();
     // ======================
     // TOP GAINERS
     // ======================

     topBuyStocks.add(
             new Stock(
                     1,
                     "RELIANCE",
                     "Reliance Industries",
                     randomPrice(2950, 3050),
                     "Large Cap"
             )
     );

     topBuyStocks.add(
             new Stock(
                     2,
                     "TCS",
                     "Tata Consultancy Services",
                     randomPrice(3800, 3900),
                     "Large Cap"
             )
     );

     topBuyStocks.add(
             new Stock(
                     3,
                     "INFY",
                     "Infosys",
                     randomPrice(1500, 1600),
                     "Large Cap"
             )
     );

     topBuyStocks.add(
             new Stock(
                     4,
                     "HDFCBANK",
                     "HDFC Bank",
                     randomPrice(1650, 1720),
                     "Large Cap"
             )
     );

     // ======================
     // TOP LOSERS
     // ======================

     topSellStocks.add(
             new Stock(
                     5,
                     "WIPRO",
                     "Wipro",
                     randomPrice(510, 540),
                     "Mid Cap"
             )
     );

     topSellStocks.add(
             new Stock(
                     6,
                     "TECHM",
                     "Tech Mahindra",
                     randomPrice(1150, 1200),
                     "Mid Cap"
             )
     );

     topSellStocks.add(
             new Stock(
                     7,
                     "HCL",
                     "HCL Tech",
                     randomPrice(1400, 1480),
                     "Large Cap"
             )
     );

     topSellStocks.add(
             new Stock(
                     8,
                     "PAYTM",
                     "Paytm",
                     randomPrice(420, 480),
                     "Mid Cap"
             )
     );

     // ======================
     // MOST ACTIVE
     // ======================

     mostTradedStocks.add(
             new Stock(
                     9,
                     "ICICIBANK",
                     "ICICI Bank",
                     randomPrice(1100, 1150),
                     "Large Cap"
             )
     );

     mostTradedStocks.add(
             new Stock(
                     10,
                     "SBIN",
                     "State Bank of India",
                     randomPrice(820, 870),
                     "Large Cap"
             )
     );

     mostTradedStocks.add(
             new Stock(
                     11,
                     "ADANIENT",
                     "Adani Enterprises",
                     randomPrice(3100, 3250),
                     "Large Cap"
             )
     );

     mostTradedStocks.add(
             new Stock(
                     12,
                     "ZOMATO",
                     "Zomato",
                     randomPrice(190, 220),
                     "Mid Cap"
             )
     );
        // SEND DATA TO HTML

        model.addAttribute(
                "topBuyStocks",
                topBuyStocks
        );

        model.addAttribute(
                "topSellStocks",
                topSellStocks
        );

        model.addAttribute(
                "mostTradedStocks",
                mostTradedStocks
        );

        return "topstocks";
    }

    // RANDOM PRICE GENERATOR

    private double randomPrice(
            double min,
            double max
    ) {

        return Math.round(
                (min + random.nextDouble()
                        * (max - min))
                        * 100.0
        ) / 100.0;
    }
}