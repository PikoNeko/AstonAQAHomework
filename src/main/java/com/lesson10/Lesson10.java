package com.lesson10;

import com.myInterfaces.WriteChecks;

import java.math.BigInteger;

public class Lesson10 implements WriteChecks {

    public static void doTask(){
        BigInteger bigInteger;

        System.out.println("Вычисление факториала от 0 до 11000 включительно");
        do {
            bigInteger = new BigInteger(WriteChecks.bigIntegerCheck().toString());
            if (bigInteger.compareTo(BigInteger.valueOf(11000)) > 0) {
                System.out.println("Слишком большое число!");
            }else {
                break;
            }
        }while (true);
        System.out.println("Факториал равен: " + factorialCalculation(bigInteger));

    }

    //Метод вычисления факториала
    private static BigInteger factorialCalculation (BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.valueOf(1)) == 0) {
            return BigInteger.valueOf(1);
        }
        else {
            return bigInteger.multiply(factorialCalculation(bigInteger.subtract(BigInteger.valueOf(1))));
        }
    }

}
