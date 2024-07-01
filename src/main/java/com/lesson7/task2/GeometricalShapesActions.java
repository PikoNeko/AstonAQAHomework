package com.lesson7.task2;

import java.util.Random;

//Интерфейс для расчета периметра и площади
public interface GeometricalShapesActions {

    void perimeterCalculation();

    void areaCalculation();

    //Default метод выбор цвета фигуры
    default String setRandomColor() {

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
