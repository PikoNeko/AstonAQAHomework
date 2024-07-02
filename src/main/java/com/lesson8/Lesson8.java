package com.lesson8;

import java.math.BigInteger;
import java.util.Scanner;

public class Lesson8 {

    //Метод ввода строки.
    private void setMaString() {
        try {
            int i = writeIntPlease();
            int j = writeIntPlease();
            Scanner in = new Scanner(System.in);
            //Переменная массива
            String[][] maStringMas = new String[i][j];
            //Проверяем массив
            validateMassive(maStringMas);

            for (i = 0; i < maStringMas.length; i++) {
                for (j = 0; j < maStringMas[i].length; j++) {
                    System.out.print("Введите строку (int): ");
                    maStringMas[i][j] = in.next();
                }
            }
            //Переменная для вывода суммы
            int masSum = 0;
            for (i = 0; i < maStringMas.length; i++) {
                for (j = 0; j < maStringMas[i].length; j++) {
                    //Проверяем строку
                    validateString(maStringMas[i][j], i, j);
                    //Складываем
                    masSum += Integer.parseInt(maStringMas[i][j]);
                }
            }
            //Выводим
            System.out.println("Сумма всех чисел: " + masSum);

        } catch (MyArraySizeException e) {
            System.out.println("Неправильный ввод: " + e.getMessage());
            setMaString();
        } catch (
                MyArrayDataException e) {
            System.out.println("Неправильный ввод: " + e.getMessage());

        }
    }

    public void doWork() {
        System.out.println("Введите значения для двумерного массива");
        setMaString();
    }

    //Метод проверки массива и для вброса исключения
    private void validateMassive(String[][] massive) throws MyArraySizeException {
        if (massive.length != 4 || massive[0].length != 4) {
            throw new MyArraySizeException("массив должен быть 4 на 4");
        }
    }

    //Метод проверки строки на возможность перевода в Int и для вброса исключения
    private void validateString(String masString, int i, int j) throws MyArrayDataException {
        BigInteger maxVal = BigInteger.valueOf(2147483647);
        BigInteger minVal = BigInteger.valueOf(-2147483648);
        BigInteger check;
        if (masString.isEmpty()) {
            throw new MyArrayDataException(String.format("здесь ничего нет! Ячейка: [%d][%d]", i, j));

        } else if (masString.matches("\\d+")) {
            check = new BigInteger(masString);
            if (check.compareTo(minVal) < 0 || check.compareTo(maxVal) > 0) {
                throw new MyArrayDataException(String.format("выход за диапазон! Ячейка: [%d][%d]", i, j));
            }
        } else {
            throw new MyArrayDataException(String.format("вписано не целое число! Ячейка: [%d][%d]", i, j));
        }
    }

    //Метод для ввода int и его проверки
    private int writeIntPlease() {
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
        }
        while (true);
        return a;
    }


}


