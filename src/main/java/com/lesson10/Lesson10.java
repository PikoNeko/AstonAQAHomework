package com.lesson10;

import com.exceptions.OutOfBoundariesException;

import java.math.BigInteger;

public class Lesson10 {


    //Метод вычисления факториала
    public static BigInteger factorialCalculation(int value) throws OutOfBoundariesException {
        //Ограничение
        int maxValue = 100;

        //Проверяем
        if (value > maxValue) {
            throw new OutOfBoundariesException("Слишком большое число!");
        }
        if (value < 0) {
            throw new OutOfBoundariesException("Нельзя вычислять факториал отрицательных чисел!");
        }
        //Обрабатываем
        if (value == 0) {
            return BigInteger.valueOf(1);
        } else {
            return BigInteger.valueOf(value).multiply(factorialCalculation((value - 1)));
        }

    }
}