package org.example.mdl;

import java.util.Currency;
import java.util.Random;

public enum CurrencyPrice {
    USD("USD"),
    EUR("EUR"),
    RUB("RUB"),
    BYN("BYN"),
    YAN("CNY");

    static {
        updatePriceCurrency();
    }

    private double price;

    private Currency currency;

    CurrencyPrice(String currencyCode) {
        this.price = price;
        currency = Currency.getInstance(currencyCode);
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    public String getSymbol() {
        return currency.getSymbol();
    }

    public static void updatePriceCurrency() {
        Random r = new Random();
        USD.setPrice(r.nextDouble(2.0, 6.0));
        EUR.setPrice(r.nextDouble(1.0, 4.5));
        RUB.setPrice(r.nextDouble(2.5, 7.0));
        BYN.setPrice(r.nextDouble(2.0, 5.4));
        YAN.setPrice(r.nextDouble(12.3, 60.0));
    }

    public Currency getCurrency() {
        return currency;
    }
}
