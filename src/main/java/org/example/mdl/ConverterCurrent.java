package org.example.mdl;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConverterCurrent {

    private CurrencyPrice baseCurrency;

    private Set<CurrencyPrice> forCurrency;

    public ConverterCurrent(CurrencyPrice baseCurrency, Set<CurrencyPrice> forCurrency) {
        this.baseCurrency = baseCurrency;
        this.forCurrency = forCurrency;
    }

    public Map<CurrencyPrice, Double> convert(Double amount) {
        return forCurrency.stream().filter(currencyPrice -> !(currencyPrice == baseCurrency))
                .collect(Collectors.toMap(Function.identity(), currencyPrice -> currencyPrice.getPrice() * amount));
    }

    public CurrencyPrice getBaseCurrency() {
        return baseCurrency;
    }

    public Set<CurrencyPrice> getForCurrency() {
        return forCurrency;
    }
}
