package com.myInterfaces;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public interface WriteChecks {

    //Метод для ввода int и его проверки
    static int IntCheck() {
        Scanner in = new Scanner(System.in);
        int a;
        do {
            System.out.print("Введите целое число: ");
            if (in.hasNextInt()) {
                a = in.nextInt();
                break;
            } else {
                System.out.println("Stop messin' around");
                in.next();
            }
        } while (true);
        return a;
    }

    //Метод для ввода BigInteger и его проверки
    static BigInteger bigIntegerCheck() {
        Scanner in = new Scanner(System.in);
        String stringCheck;
        BigInteger bigInteger;

        do {
            System.out.print("Введите целое число: ");
            stringCheck = in.nextLine();

            if(stringCheck.matches("\\d+")) {
                bigInteger = new BigInteger(stringCheck);
                break;
            } else {
                System.out.println("Stop messin' around");
                in.next();
            }
        } while (true);

        return bigInteger;
    }

    //Проверка номера. Пример: 74531234567
    static String numberCheck() {
        Scanner in = new Scanner(System.in);
        String number;
        do {
            System.out.print("Введите номер: ");
            number = in.nextLine();
            if (number.length() != 11 && number.charAt(0) != 7 && !number.matches("\\d+")) {
                System.out.println("Неверно введен номер!");

            } else return number;
        } while (true);
    }
}