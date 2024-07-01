package com.main;

import com.lesson7.task1.Lesson7_1;
import com.lesson7.task2.Lesson7_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Переменные для работы программы
        String message;
        int caseSwitch;
        Scanner in = new Scanner(System.in);

        //Цикл выбора заданий
        workingCycle:
        do {
            do {
                System.out.print("Выберите задание(1-2): ");
                if (in.hasNextInt()) {
                    caseSwitch = in.nextInt();
                    if (caseSwitch == 1 || caseSwitch == 2)
                        break;
                }
                System.out.println("Stop messin' around");
            }
            while (true);
            switch (caseSwitch) {
                case 1:
                    Lesson7_1.doTask();
                    break;
                case 2:
                    Lesson7_2.doTask();
                    break;
            }
            do {
                System.out.print("Выбрать другое задание(Y/N)? ");
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

        System.out.println("Спасибо!");
    }

}
