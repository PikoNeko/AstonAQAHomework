package com.lesson8;

import java.math.BigInteger;
import java.util.ArrayList;

public class Lesson8 {

    //Список массивов для проверки
    public final ArrayList<String[][]> TEST_DATA = new ArrayList<>() {
        {
            add(new String[][]{{"4", "73", "76", "55"}, {"Winter", "Spring", "Summer", "Autumn"}, {"December", "January", "February", "13"}, {"March", "April", "May", "75"}});

            add(new String[][]{{"34", "87", "90", "67"}, {"98799999999999999", "108", "-678", "167"}, {"304", "837", "900", "627"}, {"555", "777", "999", "666"}});

            add(new String[][]{{"34", "87", "90", "67"}, {"987", "108", "-678", "167"}, {"304", "837", "627"}, {"555", "777", "999", "666"}});

            add(new String[][]{{"987", "108", "-678", "167"}, {"304", "837", "900", "627"}, {"555", "777", "999", "666"}});

            add(new String[][]{{"987", "108", "-678", "167"}, {"304", "837", "900", "627"}, {"555", "777", "999", "666"}, {"555", "777", "999", "666"}});
        }
    };

    //Метод задания
    public void checkArray(String[][] massive) {
        try {
            validateMassive(massive);


            //Переменная для вывода суммы
            int masSum = 0;
            for (int i = 0; i < massive.length; i++) {
                for (int j = 0; j < massive[i].length; j++) {
                    //Проверяем строку
                    validateString(massive[i][j], i, j);
                    //Складываем
                    masSum += Integer.parseInt(massive[i][j]);
                }
            }
            //Выводим
            System.out.println("Сумма всех чисел: " + masSum);

        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Неправильный ввод: " + e.getMessage());
        }
    }


    //Метод проверки массива и для вброса исключения
    private void validateMassive(String[][] massive) throws MyArraySizeException {
        if (massive.length != 4) {
            throw new MyArraySizeException("Cтолбец должен быть 4");
        }
        for (String[] line : massive) {
            if (line.length != 4) {
                throw new MyArraySizeException("Строка должна быть 4");
            }
        }
    }

    //Метод проверки строки на возможность перевода в Int и для вброса исключения
    private void validateString(String masString, int i, int j) throws MyArrayDataException {
        BigInteger maxVal = BigInteger.valueOf(2147483647);
        BigInteger minVal = BigInteger.valueOf(-2147483648);
        BigInteger check;
        if (masString.isEmpty()) {
            throw new MyArrayDataException(String.format("здесь ничего нет! Ячейка: [%d][%d]", i, j));

        } else if (masString.matches("-?\\d+")) {
            check = new BigInteger(masString);
            if (check.compareTo(minVal) < 0 || check.compareTo(maxVal) > 0) {
                throw new MyArrayDataException(String.format("выход за диапазон! Ячейка: [%d][%d]", i, j));
            }
        } else {
            throw new MyArrayDataException(String.format("вписано не целое число! Ячейка: [%d][%d]", i, j));
        }
    }
}


