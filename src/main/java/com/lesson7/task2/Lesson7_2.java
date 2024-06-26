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
                    circle.setBackgroundColor();
                    circle.setBorderColor();
                    circle.printInfo();
                    break;
                //Треугольник
                case 2:
                    Triangle triangle = new Triangle();
                    triangle.setBackgroundColor();
                    triangle.setBorderColor();
                    triangle.printInfo();

                    break;
                //Квадрат
                case 3:
                    Rectangle rectangle = new Rectangle();
                    rectangle.setBackgroundColor();
                    rectangle.setBorderColor();
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
}
