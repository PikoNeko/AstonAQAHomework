package com.lesson7.task2;

import java.util.Random;
import java.util.Scanner;

//Интерфейс для расчета периметра и площади
public interface GeometricalShapesActions {

    void perimeterCalculation();

    void areaCalculation();

    //Default методы

    //Выбор цвета
    default String setColor() {

        int caseSwitch;
        int max = 3;
        int min = 1;
        Random random = new Random();

        caseSwitch = random.nextInt((max - min) + 1) + min;
        //Возвращаем рандомный цвет
        switch (caseSwitch) {
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
}
