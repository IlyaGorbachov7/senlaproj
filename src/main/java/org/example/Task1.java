package org.example;

import java.util.Random;
import java.util.Scanner;

public class Task1 {
    private static final String[] WORDS = {"home", "block", "human", "programmer", "phone", "work"};
    private static final int MAX_LIVES = 6;
    private static final String SYMBOL_HIDE = "_";

    public static void main(String[] args) {
        System.out.println("Started play 'Visiliza'!");
        Scanner scanner = new Scanner(System.in);
        String wordSecret = getRandomSecretWorld();
        char[] hidedWord = getHidedWord(wordSecret);
        int lives = MAX_LIVES;

        while (lives > 0 && String.valueOf(hidedWord).contains(SYMBOL_HIDE)) {
            System.out.println(String.format("""
                    \nWord: %s
                    There are lives left: %d
                    """, String.valueOf(hidedWord), lives));
            System.out.println("\nWord: " + String.valueOf(hidedWord));
            System.out.println("There are lives left: " + lives);
            System.out.print(">input symbol> ");
            char symbol = scanner.next().toLowerCase().charAt(0);

            if (openWordBySymbol(wordSecret, hidedWord, symbol)) {
                System.out.println("Correctly!");
            } else {
                lives--;
                System.out.println("Uncorrectable! There are lives left: " + lives);
            }
        }

        // Вывод результата игры
        if (lives > 0) {
            System.out.println("You guessed the word: " + wordSecret);
        } else {
            System.out.println("You've lost! The hidden word was:" + wordSecret);
        }

        scanner.close();
    }

    public static String getRandomSecretWorld() {
        Random random = new Random();
        return WORDS[random.nextInt(0, WORDS.length)];
    }

    public static char[] getHidedWord(String orig) {
        return orig.replaceAll(".", SYMBOL_HIDE).toCharArray();
    }

    public static boolean openWordBySymbol(String orig, char[] hided, char symbol) {
        if (orig.indexOf(symbol) >= 0) {
            for (int i = 0; i < orig.length(); i++) {
                if (orig.charAt(i) == symbol) {
                    hided[i] = symbol;
                }
            }
            return true;
        }
        return false;
    }
}