package com.lesson6;

/*1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
Конструктор класса должен заполнять эти поля при создании объекта.
Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.*/

/*2. Создать массив из 5 сотрудников. */

import java.util.Scanner;

public class Lesson6 {

    public static void doTask()
    {

        //Переменные для программы
        int caseSwitch;
        String message;
        Scanner in = new Scanner(System.in);

        //Вводим цикл для повторного прохода по программе
        workingCycle:
        do {
            do {
                System.out.print("Выберите, какое задание вы хотите просмотреть(1-2): ");
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
                    //Объявляем массив класса
                    Employee[] employeeArray = new Employee[5];

                    //Вводим данные в массив
                    employeeArray[0] = new Employee();
                    employeeArray[1] = new Employee("Александр", "Александров", "Александрович",
                            "Инженер", "alex@mailbox.com", "+7 (006) 474-80-89", 20000, 30);
                    employeeArray[2] = new Employee("Сергей", "Сергеев", "Сергеевич", "Программист",
                            "serg@mailbox.com", "+7 (473) 284-63-07", 25000, 18);
                    employeeArray[3] = new Employee("Алексей", "Алексеев", "Алексеевич", "QA Инженер",
                            "alex2000@mailbox.com", "+7 (215) 799-33-91", 200000, 20);
                    employeeArray[4] = new Employee("Игорь", "Игорев", "Игоревич", "Менеджер",
                            "@mailbox.com", "+7 (358) 309-32-48", 50000, 47);

                    //Выводим массив с помощью метода класса
                    for (Employee i : employeeArray) {
                        i.print();
                    }
                    break;

                case 2:
                    //Объявляем внутренний класс
                    Park.AttractionInfo carousel = new Park().new AttractionInfo();
                    //Выводим внутренний класс
                    carousel.print();
                    break;

            }
            do {
                System.out.print("Выбрать другой метод(Y/N)? ");
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

