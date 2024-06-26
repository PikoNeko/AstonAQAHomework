package com.lesson5;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class Lesson5 {


    public static void chooseMethod() {
        //Переменные для работы с методами
        int a, b;
        String message;
        Scanner in = new Scanner(System.in);
        boolean outOfCycle = false;
        boolean outOfInnerCycle = false;
        //выбор метода
        do {
            System.out.println("Пожалуйста выберите метод (1-14)");
            a = writeIntPlease(in);
            switch (a) {
                case 1:
                    //1
                    //Метод при вызове печатает в столбец три слова: Orange, Banana, Apple
                    printThreeWords();
                    break;

                case 2:
                    //2
                    /* Метод должен просуммировать объявленные в нем 2 int переменные,
                    и если их сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”,
                    в противном случае - “Сумма отрицательная” */
                    checkSumSign();
                    break;

                case 3:
                    //3
                    /* Метод объявляет int переменную value.
                    Если объявленная переменная меньше 0 (0 включительно),
                    то в консоль метод должен вывести сообщение “Красный”,
                    если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
                    если больше 100 (100 исключительно) - “Зеленый” */
                    printColor();
                    break;

                case 4:
                    //4
                    /* Объявляем в методе int переменные a и b.
                    Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”,
                    в противном случае “a < b”. */
                    compareNumbers();
                    break;

                case 5:
                    //5
                    /* Метод, принимающий на вход два целых числа и проверяющий,
                    что их сумма лежит в пределах от 10 до 20 (включительно),
                    если да – вернуть true, в противном случае – false. */
                    System.out.println("Для этого метода нужна ввести числа.");
                    a = writeIntPlease(in);
                    b = writeIntPlease(in);
                    System.out.println("Сумма лежит в пределах от 10 до 20 (включительно): " + sumCompareFromTenToTwenty(a, b));
                    break;

                case 6:
                    // 6
                    /* метод, который в качестве параметра принимает целое число,
                    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
                    Замечание: ноль считаем положительным числом. */
                    System.out.println("Для этого метода нужно ввести число.");
                    a = writeIntPlease(in);
                    oddOrEven(a);
                    break;

                case 7:
                    // 7
                    /* Метод, которому в качестве параметра передается целое число.
                    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
                    Замечание: ноль считаем положительным числом. */
                    System.out.println("Для этого метода нужно ввести число.");
                    a = writeIntPlease(in);
                    System.out.println("Число отрицательное - " + boolOddOrEven(a));
                    break;

                case 8:
                    // 8
                    /* Метод, которому в качестве аргументов передается строка и число,
                    метод должен отпечатать в консоль строку, указанное количество раз */
                    System.out.print("Введите строку: ");
                    message = in.next();
                    do {
                        a = writeIntPlease(in);
                        if (a <= 0) {
                            System.out.println("А можно что-то больше 0?");
                        }
                    } while (a <= 0);
                    writeHowMuch(message, a);
                    break;

                case 9:
                    //9
                    /* Метод, который определяет, является ли год високосным,
                    и возвращает boolean (високосный - true, не високосный - false).
                    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный. */
                    System.out.println("Этот год високосный - " + leapYear());
                    break;

                case 10:
                    //10
                    /* Метод создает целочисленный массив, состоящий из элементов 0 и 1.
                    С помощью цикла и условия меняем 0 на 1, 1 на 0. */
                    switchingBools();
                    break;

                case 11:
                    //11
                    /* Метод создает пустой целочисленный массив длиной 100.
                    С помощью цикла заполняем его значениями от 1 до 100. */
                    thousandMassive();
                    break;

                case 12:
                    //12
                    /* Метод создает массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ].
                    С помощью цикла умножаем число из массива на 2, если оно меньше 6. */
                    lessThenSix();
                    break;

                case 13:
                    //13
                    /* Метод Создает квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
                    и с помощью циклов заполняет его диагональные элементы единицами*/
                    fillMasiveDiagonals();
                    break;

                case 14:
                    //14
                    /* Метод, принимающий на вход два аргумента: len и initialValue,
                    и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.*/
                    System.out.println("Для этого метода нужна ввести числа.");
                    a = writeIntPlease(in);
                    b = writeIntPlease(in);
                    System.out.println(Arrays.toString(fillMassiveWith(a, b)));
                    break;

                default:
                    throw new AssertionError();
            }

            do {
                System.out.print("Выбрать другой метод(Y/N)? ");
                message = in.next();

                if (message.equals("N")) {
                    outOfCycle = true;
                    outOfInnerCycle = true;
                } else if (message.equals("Y")) {
                    outOfInnerCycle = true;
                } else {
                    System.out.println("Stop messin' around");
                }
            } while (outOfInnerCycle != true);
            outOfInnerCycle = false;

        } while (outOfCycle != true);

        System.out.println("Спасибо!");
    }

    //1
    /* Метод при вызове печатает в столбец три слова: Orange, Banana, Apple */
    public static void printThreeWords() {
        System.out.println("Orange" + "\n" + "Banana" + "\n" + "Apple");
    }


    //2
    /* Метод должен просуммировать объявленные в нем 2 int переменные,
    и если их сумма больше или равна 0, то вывести в консоль сообщение “Сумма положительная”,
    в противном случае - “Сумма отрицательная” */
    public static void checkSumSign() {
        int a = -7;
        int b = 543;
        String message = (a + b) >= 0 ? " Сумма положительная" : " Сумма отрицательная";
        System.out.println(a + " " + b + message);
    }

    //3
    /* Метод объявлят int переменную value.
    Если объявленная переменная меньше 0 (0 включительно),
    то в консоль метод должен вывести сообщение “Красный”,
    если лежит в пределах от 0 (0 исключительно) до 100 (100 включительно), то “Желтый”,
    если больше 100 (100 исключительно) - “Зеленый” */
    public static void printColor() {
        int value = 0;
        String message;
        if (value <= 0)
            message = " Красный";
        else if (value > 100)
            message = " Зеленый";
        else
            message = " Желтый";
        System.out.println(value + message);
    }

    //4
    /* Объявляем в методе int переменные a и b.
    Если a больше или равно b, то необходимо вывести в консоль сообщение “a >= b”,
    в противном случае “a < b”. */
    public static void compareNumbers() {
        int a = 87;
        int b = 3;
        String message = a >= b ? " a >= b" : " a < b";
        System.out.println("a: " + a + " b: " + b + message);
    }

    // 5
    /* Метод, принимающий на вход два целых числа и проверяющий,
    что их сумма лежит в пределах от 10 до 20 (включительно),
    если да – вернуть true, в противном случае – false. */
    public static boolean sumCompareFromTenToTwenty(int a, int b) {
        boolean letsCheck = (a + b) >= 10 && (a + b) <= 20;
        return letsCheck;
    }

    // 6
    /* метод, который в качестве параметра принимает целое число,
    метод должен напечатать в консоль, положительное ли число передали или отрицательное.
    Замечание: ноль считаем положительным числом. */
    public static void oddOrEven(int a) {
        String message;

        message = a >= 0 ? " - положительное" : " - отрицательное";
        System.out.println(a + message);
    }

    // 7
    /* Метод, которому в качестве параметра передается целое число.
    Метод должен вернуть true, если число отрицательное, и вернуть false если положительное.
    Замечание: ноль считаем положительным числом. */
    public static boolean boolOddOrEven(int a) {
        boolean checkBool;

        checkBool = a < 0;
        return checkBool;
    }

    // 8
    /* Метод, которому в качестве аргументов передается строка и число,
    метод должен отпечатать в консоль указанную строку, указанное количество раз */
    public static void writeHowMuch(String a, int b) {
        System.out.println("Как пожелаете:");
        for (int i = 0; i < b; i++) {
            System.out.println(a);
        }
    }

    //9
    /* Метод, который определяет, является ли год високосным,
    и возвращает boolean (високосный - true, не високосный - false).
    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный. */
    public static boolean leapYear() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) return true;
        else return false;

    }

    //10
    /* Метод создает целочисленный массив, состоящий из элементов 0 и 1.
    С помощью цикла и условия меняем 0 на 1, 1 на 0. */
    public static void switchingBools() {
        int[] taskMassive = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(taskMassive));

        for (int i = 0; i < taskMassive.length; i++) {
            switch (taskMassive[i]) {
                case 0:
                    taskMassive[i] = 1;
                    break;
                case 1:
                    taskMassive[i] = 0;
                    break;
            }
        }

        System.out.println(Arrays.toString(taskMassive));
    }

    //11
    /* Метод создает пустой целочисленный массив длиной 100.
    С помощью цикла заполняем его значениями от 1 до 100. */
    public static void thousandMassive() {
        int[] taskMassive = new int[100];
        for (int i = 0; i < taskMassive.length; i++) {
            taskMassive[i] = i + 1;
        }

        System.out.println(Arrays.toString(taskMassive));
    }

    //12
    /* Метод создает массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ].
    С помощью цикла умножаем число из массива на 2, если оно меньше 6. */
    public static void lessThenSix() {
        int[] taskMassive = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(taskMassive));

        for (int i = 0; i < taskMassive.length; i++) {
            if (taskMassive[i] < 6) taskMassive[i] *= 6;
        }

        System.out.println(Arrays.toString(taskMassive));
    }

    //13
    /* Метод Создает квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью циклов заполняет его диагональные элементы единицами*/
    public static void fillMasiveDiagonals() {
        int[][] taskMassive = new int[9][9];

        for (int i = 0; i < taskMassive.length; i++) {
            for (int j = 0; j < taskMassive[i].length; j++) {
                if (i == j || (i + j) == (taskMassive.length - 1)) {
                    taskMassive[i][j] = 1;
                    System.out.print("|" + taskMassive[i][j]);
                } else {
                    taskMassive[i][j] = 0;
                    System.out.print("|" + taskMassive[i][j]);
                }
            }
            System.out.println("|");
        }
    }

    //14
    /* Метод, принимающий на вход два аргумента: len и initialValue,
    и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue.*/
    public static int[] fillMassiveWith(int len, int initialValue) {
        int[] taskMassive = new int[len];

        for (int i = 0; i < taskMassive.length; i++) {
            taskMassive[i] = initialValue;
        }

        return taskMassive;
    }

    //Метод для ввода int и его проверки
    public static int writeIntPlease(Scanner in) {
        int a = 0;
        boolean checkInt = false;
        do {
            System.out.print("Введите целое число: ");
            if (in.hasNextInt()) {
                a = in.nextInt();
                checkInt = true;
            } else {
                System.out.println("Stop messin' around");
                in.next();
            }
        }
        while (checkInt != true);

        return a;
    }
}
