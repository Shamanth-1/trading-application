package com.chainsys.tradingapp.service;

import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Random;

@Service
public class MarketDataService {

    private final Random random = new Random();

    public String getNSEMarketData() {

        DecimalFormat df = new DecimalFormat("0.00");

        double nifty =
                24450 + random.nextDouble() * 200;

        double bankNifty =
                52300 + random.nextDouble() * 300;

        double sensex =
                80100 + random.nextDouble() * 400;

        double niftyIT =
                38120 + random.nextDouble() * 150;

        double reliance =
                2980 + random.nextDouble() * 50;

        double tcs =
                3850 + random.nextDouble() * 60;

        double infosys =
                1540 + random.nextDouble() * 40;

        double hdfc =
                1670 + random.nextDouble() * 30;

        return """
                ==============================
                      NSE LIVE MARKET
                ==============================

                NIFTY 50
                --------------------------------
                Value  : %s
                Change : +0.52%%

                BANK NIFTY
                --------------------------------
                Value  : %s
                Change : +0.44%%

                SENSEX
                --------------------------------
                Value  : %s
                Change : +0.40%%

                NIFTY IT
                --------------------------------
                Value  : %s
                Change : -0.20%%

                ==============================
                     TOP ACTIVE STOCKS
                ==============================

                RELIANCE
                Price   : ₹%s
                Change  : +1.12%%

                TCS
                Price   : ₹%s
                Change  : +0.84%%

                INFOSYS
                Price   : ₹%s
                Change  : -0.35%%

                HDFC BANK
                Price   : ₹%s
                Change  : +0.63%%

                ==============================
                Market Status : OPEN
                Last Updated  : LIVE
                ==============================
                """
                .formatted(
                        df.format(nifty),
                        df.format(bankNifty),
                        df.format(sensex),
                        df.format(niftyIT),
                        df.format(reliance),
                        df.format(tcs),
                        df.format(infosys),
                        df.format(hdfc)
                );
    }
}