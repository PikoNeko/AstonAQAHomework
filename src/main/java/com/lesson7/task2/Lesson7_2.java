package com.lesson7.task2;

import java.util.Scanner;

public class Lesson7_2 {
    public static void doTask() {

        //Переменные для работы программы
        String message;
        int caseSwitch;
        Scanner in = new Scanner(System.in);

        //цикл повторного прохождения по программе
        workingCycle:
        do {
            //Цикл проверки выбора
            do {
                System.out.print("Выберите, кого вы хотите создать. Круг - 1, Треугольник - 2, Прямоугольник - 3: ");
                if (in.hasNextInt()) {
                    caseSwitch = in.nextInt();
                    if (caseSwitch == 1 || caseSwitch == 2 || caseSwitch == 3)
                        break;
                }
                System.out.println("Stop messin' around");
            }
            while (true);

            //Выбор фигуры
            switch (caseSwitch) {
                //Круг
                case 1:
                    Circle circle = new Circle();
                    System.out.println("Введите радиус");
                    circle.setRadius(writeDouble());
                    circle.setBackgroundColor(circle.setColor()); ;
                    circle.setBorderColor(circle.setColor());
                    circle.printInfo();
                    break;
                //Треугольник
                case 2:
                    Triangle triangle = new Triangle();
                    System.out.println("Введите сторону А");
                    triangle.setSideA(writeDouble());
                    System.out.println("Введите сторону B");
                    triangle.setSideB(writeDouble());
                    System.out.println("Введите сторону C");
                    triangle.setSideC(writeDouble());
                    triangle.setBackgroundColor(triangle.setColor());
                    triangle.setBorderColor(triangle.setColor());
                    triangle.printInfo();

                    break;
                //Квадрат
                case 3:
                    Rectangle rectangle = new Rectangle();
                    System.out.println("Введите сторону А");
                    rectangle.setSideA(writeDouble());
                    System.out.println("Введите сторону B");
                    rectangle.setSideB(writeDouble());
                    rectangle.setBackgroundColor(rectangle.setColor());
                    rectangle.setBorderColor(rectangle.setColor());
                    rectangle.printInfo();
                    break;
            }
            //Проверяем, не нужно ли сделать что-то еще в программе
            do {
                System.out.print("Создать другую фигуру(Y/N)? ");
                message = in.next();

                if (message.equals("N")) {
                    break workingCycle;
                } else if (message.equals("Y")) {
                    break;
                } else {
                    System.out.println("Stop messin' around");
                }
            } while (true);

        } while (true);
    }
    private static double writeDouble(){

        Scanner in = new Scanner(System.in);
        //Проверка на double вписанной строки
        do {
            System.out.print("Введите целое число или число с плавающей точкой число: ");
            if (in.hasNextDouble()) {
                return in.nextDouble();
            } else {
                System.out.println("Stop messin' around");
                in.next();
            }
        }
        while (true);
    }
}
