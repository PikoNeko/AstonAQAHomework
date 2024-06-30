package com.lesson7.task1;

import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import net.datafaker.Faker;

public class Lesson7_1 {

    //Создаем метод для использования в Main
    public static void doTask() {

        //Объявляем переменные для работы программы
        String message;
        int caseSwitch;
        Scanner in = new Scanner(System.in);
        Faker faker = new Faker();

        //Переменные для ссылки на объект
        Cat catRef;
        Dog dogRef;
        //Создаем список котов
        LinkedList<Cat> listOfCats = Stream.
                generate(() -> new Cat(faker.cat().name()))
                .limit(10).
                collect(Collectors.toCollection(LinkedList::new));

        //Вводим цикл для повторного прохода по программе
        workingCycle:
        do {
            //Цикл проверки выбора
            do {
                System.out.print("Выберите, кого вы хотите создать. Кот - 1, собака - 2, (Подсчитать животных - 3) (Добавить корма - 4) (Покормить котов - 5) (Выйти - 6): ");
                if (in.hasNextInt()) {
                    caseSwitch = in.nextInt();
                    if (caseSwitch == 1 || caseSwitch == 2 || caseSwitch == 3 || caseSwitch == 4 || caseSwitch == 5 || caseSwitch == 6)
                        break;
                }
                System.out.println("Stop messin' around");
            }
            while (true);

            switch (caseSwitch) {
                //Работаем с котами
                case 1:
                    //Вводим имя кота
                    do {
                        System.out.print("Введите имя кота: ");
                        message = in.next();

                        if (message.isEmpty()) {
                            System.out.println("Stop messin' around");
                        } else {
                            break;
                        }
                    } while (true);

                    //Добавляем нового кота в список животных и считаем их
                    listOfCats.add(new Cat(message));
                    //Добавляем ссылку в catRef для упрощения обращения
                    catRef = listOfCats.getLast();
                    //Цикл опций с котом
                    catLoop:
                    do {
                        //Выбираем опцию
                        do {
                            System.out.println("Что вы хотите сделать с " + catRef.getName() + "?" + "\n" +
                                    "Пробежка - 1" + "\n" +
                                    "Плавание - 2" + "\n" +
                                    "Выход к зоопарку - 3");
                            caseSwitch = writeIntPlease(in);
                        } while (caseSwitch != 1 && caseSwitch != 2 && caseSwitch != 3 && caseSwitch != 4);

                        switch (caseSwitch) {
                            //Бегаем
                            case 1:
                                System.out.println("Сколько " + catRef.getName() + " должен пробежать?");
                                catRef.run(writeIntPlease(in));
                                catRef.setFullness(false);
                                break;
                            //Плаваем (ах если бы ты умел плавать, котик)
                            case 2:
                                System.out.println("Сколько " + catRef.getName() + " должен проплыть?");
                                catRef.swim(writeIntPlease(in));
                                catRef.setFullness(false);
                                break;
                            case 3:
                                break catLoop;
                        }
                        do {
                            System.out.print("Выбрать другую опцию с " + catRef.getName() + "? (Y/N) ");
                            message = in.next();

                            if (message.equals("N")) {
                                break catLoop;
                            } else if (message.equals("Y")) {
                                break;
                            } else {
                                System.out.println("Stop messin' around");
                            }
                        } while (true);
                    } while (true);
                    break;

                //Работает с собаками
                case 2:
                    //Вводим имя собаки
                    do {
                        System.out.print("Введите имя собаки: ");
                        message = in.next();

                        if (message.isEmpty()) {
                            System.out.println("Stop messin' around");
                        } else {
                            break;
                        }
                    } while (true);

                    //Добавляем новую собаку в список животных и считаем их
                    dogRef = new Dog(message);
                    //Цикл опций с собакой
                    dogLoop:
                    do {
                        //Выбираем опцию
                        do {
                            System.out.println("Что вы хотите сделать с " + dogRef.getName() + "?" + "\n" +
                                    "Пробежка - 1" + "\n" +
                                    "Плавание - 2" + "\n" +
                                    "Выход к зоопарку - 3");
                            caseSwitch = writeIntPlease(in);
                        } while (caseSwitch != 1 && caseSwitch != 2 && caseSwitch != 3);

                        switch (caseSwitch) {
                            //Бегаем
                            case 1:
                                System.out.println("Сколько " + dogRef.getName() + " должен пробежать?");
                                dogRef.run(writeIntPlease(in));
                                break;
                            //Плаваем (Хороший мальчик)
                            case 2:
                                System.out.println("Сколько " + dogRef.getName() + " должен проплыть?");
                                dogRef.swim(writeIntPlease(in));
                                break;
                            case 3:
                                break dogLoop;
                        }
                        //Проверяем, хотят ли что-то еще делать с собакой
                        do {
                            System.out.print("Выбрать другую опцию с " + dogRef.getName() + "? (Y/N) ");
                            message = in.next();

                            if (message.equals("N")) {
                                break dogLoop;
                            } else if (message.equals("Y")) {
                                break;
                            } else {
                                System.out.println("Stop messin' around");
                            }
                        } while (true);
                    } while (true);
                    break;

                //Выводим количество животных
                case 3:
                    //Выводим подсчет
                    System.out.println("У нас тут уже " + (Animal.getAnimalCount()) + " животных");
                    System.out.println("Кошек: " + Cat.getCatCount());
                    System.out.println("Собак: " + Dog.getDogCount());
                    break;

                //Добавляем еду в миску
                case 4:
                    Bowl.setCatFood(writeIntPlease(in));
                    System.out.println("Корм добавлен!");
                    break;

                //Кормим котов в списке
                case 5:
                    //Если миска опустела
                    if (Bowl.getCatFood() == 0) {
                        System.out.println("Миска пуста!");
                        break;
                    }

                    //Идем по котам
                    int i = 0;
                    while (i < listOfCats.size()) {
                        catRef = listOfCats.get(i);
                        if (!catRef.isFullness()) {
                            if (Bowl.getCatFood() > 5) {
                                Bowl.setCatFood(Bowl.getCatFood() - 5);
                                catRef.setFullness(true);
                            } else {
                                break;
                            }
                        }
                        i++;
                    }

                    //Выводим котов
                    System.out.println("Список котов:");
                    for (Cat k : listOfCats) {
                        message = k.isFullness() ? " - Сыт" : " - Голоден";
                        System.out.println(k.getName() + message);
                    }
                    System.out.println("В миске осталось: " + Bowl.getCatFood());
                    break;
                case 6:
                    break workingCycle;
            }

            //Проверяем, не нужно ли сделать что-то еще в программе
            do {
                System.out.print("Увеличим зоопарк(Y/N)? ");
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

    //Метод для ввода int и его проверки
    public static int writeIntPlease(Scanner in) {
        int a;
        do {
            System.out.print("Введите целое число: ");
            if (in.hasNextInt()) {
                a = in.nextInt();
                break;
            } else {
                System.out.println("Stop messin' around");
                in.next();
            }
        }
        while (true);
        return a;
    }
}
