package org.example;

import org.example.mdl.ConverterCurrent;
import org.example.mdl.CurrencyPrice;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class Task2 {

    public static void main(String[] args) {
        boolean isDouble = false;
        Scanner scanner = new Scanner(System.in);
        ConverterCurrent converter = new ConverterCurrent(CurrencyPrice.USD, Set.of(CurrencyPrice.values()));
        System.out.println("Converter currency is started: ");

        do {
            System.out.print(String.format(">Enter the amount in %s > ", converter.getBaseCurrency()));
            if (scanner.hasNextDouble()) {
                isDouble = true;
            } else {
                System.out.println("You should enter double value. You entered uncorrectable value: " + scanner.next());
            }
        } while (!isDouble);
        double amount = scanner.nextDouble();
        converter.convert(amount)
                .forEach(((currencyPrice, res) -> {
                    NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.ROOT);
                    var f = new NumberFormatter();

                    formatter.setCurrency(currencyPrice.getCurrency());
                    System.out.println(String.format("The amount in %s (1%s == %s) == %s", currencyPrice, converter.getBaseCurrency().getSymbol(),
                            formatter.format(currencyPrice.getPrice()), formatter.format(res)));
                }));
    }

}
