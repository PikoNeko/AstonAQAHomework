package com.lesson7.task2;

import java.util.Scanner;

//Интерфейс для расчета периметра и площади
public interface GeometricalShapesActions {

    void perimeterCalculation();

    void areaСalculation();

    //Default методы

    //Выбор цвета
    default String setColor() {
        int caseSwitch;
        Scanner in = new Scanner(System.in);

        //Цикл выбора
        do {
            System.out.println("Выберите цвет: 1 - Синий, 2 - Зеленый, 3 - Красный");
            if (in.hasNextInt()) {
                caseSwitch = in.nextInt();
                if (caseSwitch == 1 || caseSwitch == 2 || caseSwitch == 3)
                    break;
            }
            System.out.println("Stop messin' around");
        }
        while (true);
        //Возвращаем выбранный цвет
        switch (caseSwitch){
            case 1:
                return "Синий";
            case 2:
                return "Зеленый";
            case 3:
                return "Красный";
            default:
                throw new IllegalStateException("Unexpected value: " + caseSwitch);
        }

    }

    //Метод для возврата переменной после PRIVATE writeDouble
    default double setDouble(){
        return writeDouble();
    }

    ////Метод для ввода double и его проверки
    private double writeDouble(){

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
