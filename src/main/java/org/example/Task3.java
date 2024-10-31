package org.example;

import org.example.mdl.GeneratorPassword;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        boolean isInt = false;
        Scanner scanner = new Scanner(System.in);
        int length = 0;
        do {
            System.out.print(String.format(">Enter length password> "));
            if (scanner.hasNextInt()) {
                isInt = true;
                length = scanner.nextInt();
                if (length < 8 || length > 12) {
                    isInt = false;
                    System.out.println("Length of password is uncorrectable! Length should be from 8 to 12");
                }
            } else {
                System.out.println("You should enter int value. You entered uncorrectable value: " + scanner.next());
            }
        } while (!isInt);

        String password = GeneratorPassword.generatePassword(length);
        System.out.println("Generated password: " + password);
        scanner.close();
    }
}
