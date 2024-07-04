package com.main;

import com.lesson9.Task1;
import com.lesson9.Task2;
import com.myInterfaces.WriteChecks;

public class Main implements WriteChecks {
    public static void main(String[] args) {

        workingCycle:
        do{
            System.out.println("Выберите задание(1-2) (Выйти-3)");
            switch (WriteChecks.IntCheck()) {
                case 1:
                    Task1.doTask();
                    break;
                case 2:
                    Task2.doTask();
                    break;
                case 3:
                    System.out.println("Спасибо!");
                    break workingCycle;
            }
        }while (true);



    }


}
