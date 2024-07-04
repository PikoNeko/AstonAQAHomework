package com.lesson9;

import com.myInterfaces.WriteChecks;

public class Task2 implements WriteChecks {

    public static void doTask(){

    PhoneBook phoneBook = new PhoneBook();
    phoneBook.addRandomsToList();

    workingCycle:
    do {
        System.out.println("Добавить запись - 1, Найти запись - 2, Вывести весь список - 3 (Выйти - 4)");
        switch (WriteChecks.IntCheck()){
            case 1:
                phoneBook.add();
                break;
            case 2:
                phoneBook.get();
                break;
            case 3:
                phoneBook.printRecords();
                break;
            case 4:
                break workingCycle;
        }
    }while (true);

    }
}
