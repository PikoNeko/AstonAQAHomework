package com.lesson7.task1;

import java.util.ArrayList;
import java.util.Scanner;

public class Lesson7_1 {

    //Создаем метод для использования в Main
    public static void doTask() {

        //Объявляем переменные для работы программы
        String message;
        int caseSwitch;
        Scanner in = new Scanner(System.in);

        //Переменная для ссылки на объект
        Cat catRef;
        //Переменные для подсчета животных;
        int catCount = 0, dogCount = 0, beastCount = 0;
        //Создаем список животных и переменную для подсчета (прохода по списку)
        ArrayList<Animal> listOfAnimals = new ArrayList<>();
        int animalCount = -1;

        //Кошачья миска
        int catBowl = 0;

        //Вводим цикл для повторного прохода по программе
        workingCycle:
        do {
            //Цикл проверки выбора
            do {
                System.out.print("Выберите, кого вы хотите создать. Кот - 1, собака - 2, животное - 3 (Подсчитать животных? - 4) (Покормить котов - 5): ");
                if (in.hasNextInt()) {
                    caseSwitch = in.nextInt();
                    if (caseSwitch == 1 || caseSwitch == 2 || caseSwitch == 3 || caseSwitch == 4 || caseSwitch == 5)
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
                    listOfAnimals.add(new Cat(message));
                    catCount++;
                    animalCount++;
                    //Добавляем ссылку в catRef для упрощения обращения
                    catRef = (Cat) listOfAnimals.get(animalCount);
                    //Цикл опций с котом
                    catLoop:
                    do {
                        //Выбираем опцию
                        do {
                            System.out.println("Что вы хотите сделать с " + catRef.getName() + "?" + "\n" +
                                    "Пробежка - 1" + "\n" +
                                    "Плавание - 2" + "\n" +
                                    "Покормить - 3");
                            caseSwitch = writeIntPlease(in);
                        } while (caseSwitch != 1 && caseSwitch != 2 && caseSwitch != 3);

                        switch (caseSwitch) {
                            //Бегаем
                            case 1:
                                System.out.println("Сколько " + catRef.getName() + " должен пробежать?");
                                catRef.run(writeIntPlease(in));
                                catRef.setFullness(false);
                                catRef.workout();
                                break;
                            //Плаваем (ах если бы ты умел плавать, котик)
                            case 2:
                                System.out.println("Сколько " + catRef.getName() + " должен проплыть?");
                                catRef.swim(writeIntPlease(in));
                                catRef.setFullness(false);
                                catRef.workout();
                                break;
                            //Кормим, пока не наестся
                            case 3:
                                //Проверяем, сыт ли кот
                                if (catRef.isFullness()) {
                                    System.out.println("Котик уже сыт.");
                                    break;
                                }
                                do {
                                    do {
                                        System.out.println("Сейчас в миске " + catBowl + " корма. Попытаться покормить " + catRef.getName() + " - 1" + "\n" +
                                                "Добавить корма - 2: ");
                                        caseSwitch = writeIntPlease(in);
                                    } while (caseSwitch != 1 && caseSwitch != 2);

                                    switch (caseSwitch) {
                                        //Кормим
                                        case 1:
                                            //Если в миске больше, чем сможет съесть кот
                                            if (catBowl >= (20 - catRef.getStomach())) {
                                                catBowl -= (20 - catRef.getStomach());
                                                catRef.setStomach(20);
                                                catRef.setFullness(true);
                                                System.out.println("Ура! Котик наелся!");
                                            } else {
                                                //Если в миске ничего нет
                                                if (catBowl == 0) {
                                                    System.out.println("Ну хоть что-то в миску надо положить.");
                                                    //Если хоть что-то есть
                                                } else {
                                                    catRef.setStomach(catBowl);
                                                    catBowl = 0;
                                                    System.out.println("Котик поел, но в миске маловато еды, положите еще хотя бы " +
                                                            (catBowl + 20 - catRef.getStomach()));
                                                }
                                            }

                                            break;
                                        case 2:
                                            //Добавляем корм в миску
                                            catBowl = addFood(catBowl, in);
                                            break;

                                    }
                                } while (!catRef.isFullness());
                                break;
                        }
                        //Проверяем, хотят ли что-то еще делать с котом
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
                    listOfAnimals.add(new Dog(message));
                    dogCount++;
                    animalCount++;

                    //Цикл опций с собакой
                    dogLoop:
                    do {
                        //Выбираем опцию
                        do {
                            System.out.println("Что вы хотите сделать с " + listOfAnimals.get(animalCount).getName() + "?" + "\n" +
                                    "Пробежка - 1" + "\n" +
                                    "Плавание - 2");
                            caseSwitch = writeIntPlease(in);
                        } while (caseSwitch != 1 && caseSwitch != 2);

                        switch (caseSwitch) {
                            //Бегаем
                            case 1:
                                System.out.println("Сколько " + listOfAnimals.get(animalCount).getName() + " должен пробежать?");
                                listOfAnimals.get(animalCount).run(writeIntPlease(in));
                                break;
                            //Плаваем (Хороший мальчик)
                            case 2:
                                System.out.println("Сколько " + listOfAnimals.get(animalCount).getName() + " должен проплыть?");
                                listOfAnimals.get(animalCount).swim(writeIntPlease(in));
                                break;
                        }
                        //Проверяем, хотят ли что-то еще делать с собакой
                        do {
                            System.out.print("Выбрать другую опцию с " + listOfAnimals.get(animalCount).getName() + "? (Y/N) ");
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

                //Работаем с животными
                case 3:
                    //Вводим имя животного
                    do {
                        System.out.print("Введите имя животного: ");
                        message = in.next();

                        if (message.isEmpty()) {
                            System.out.println("Stop messin' around");
                        } else {
                            break;
                        }
                    } while (true);

                    //Добавляем новое животное в список животных и считаем их
                    listOfAnimals.add(new Animal(message));
                    beastCount++;
                    animalCount++;

                    //Цикл опций с животным
                    animalLoop:
                    do {
                        //Выбираем опцию
                        do {
                            System.out.println("Что вы хотите сделать с " + listOfAnimals.get(animalCount).getName() + "?" + "\n" +
                                    "Пробежка - 1" + "\n" +
                                    "Плавание - 2");
                            caseSwitch = writeIntPlease(in);
                        } while (caseSwitch != 1 && caseSwitch != 2);

                        switch (caseSwitch) {
                            //Бегаем
                            case 1:
                                System.out.println("Сколько " + listOfAnimals.get(animalCount).getName() + " должен пробежать?");
                                listOfAnimals.get(animalCount).run(writeIntPlease(in));
                                break;
                            //Плаваем
                            case 2:
                                System.out.println("Сколько " + listOfAnimals.get(animalCount).getName() + " должен проплыть?");
                                listOfAnimals.get(animalCount).swim(writeIntPlease(in));
                                break;
                        }
                        //Проверяем, хотят ли что-то еще делать с собакой
                        do {
                            System.out.print("Выбрать другую опцию с " + listOfAnimals.get(animalCount).getName() + "? (Y/N) ");
                            message = in.next();

                            if (message.equals("N")) {
                                break animalLoop;
                            } else if (message.equals("Y")) {
                                break;
                            } else {
                                System.out.println("Stop messin' around");
                            }
                        } while (true);
                    } while (true);
                    break;

                //Выводим количество животных
                case 4:
                    if (animalCount < 0) {
                        System.out.println("Тут пока еще нет животных");
                    } else {
                        //Выводим подсчет
                        System.out.println("У нас тут уже " + (animalCount + 1) + " животных");
                        System.out.println("Кошек: " + catCount);
                        System.out.println("Собак: " + dogCount);
                        System.out.println("Других животных: " + beastCount);
                    }
                    break;

                //Кормим котов в списке
                case 5:
                    //Если нет котов
                    if (catCount == 0) {
                        System.out.println("Но у нас пока нет котов!");
                        break;
                    }
                    //Выводим котов
                    System.out.println("Список котов:");
                    for (Animal k : listOfAnimals) {
                        message = ((Cat) k).isFullness() ? " - Сыт" : " - Голоден";
                        System.out.println(k.getName() + message);
                    }
                    //Идем по котам
                    feedingCat:
                    for (int i = 0; i < listOfAnimals.size(); i++) {
                        //Ищем котов в списке
                        if (listOfAnimals.get(i).getClass() == Cat.class) {
                            catRef = (Cat) listOfAnimals.get(i);
                            //Если миска опустела
                            if (catBowl == 0) {
                                System.out.println("Миска пуста");
                                System.out.println("Список котов:");
                                for (Animal k : listOfAnimals) {
                                    message = ((Cat) k).isFullness() ? " - Сыт" : " - Голоден";
                                    System.out.println(k.getName() + message);
                                }
                                //Добавляем еду
                                addingFood:
                                for (Animal j : listOfAnimals) {
                                    if (!((Cat) j).isFullness()) {
                                        do {
                                            System.out.print("Не все коты еще наелись. Добавить еще корма?(Y/N) ");
                                            message = in.next();
                                            if (message.equals("N")) {
                                                break feedingCat;
                                            } else if (message.equals("Y")) {
                                                catBowl = addFood(catBowl, in);
                                                i--;
                                                break addingFood;
                                            } else {
                                                System.out.println("Stop messin' around");
                                            }
                                        } while (true);
                                    }
                                }
                            } else {
                                if (catBowl >= (20 - catRef.getStomach())) {
                                    catBowl -= (20 - catRef.getStomach());
                                    catRef.setStomach(20);
                                    catRef.setFullness(true);
                                    System.out.println(catRef.getName() + " наелся!");

                                } else {
                                    catRef.setStomach(catBowl);
                                    catBowl = 0;
                                    System.out.println(catRef.getName() + " поел, но в миске маловато еды, положите еще хотя бы " +
                                            (catBowl + 20 - catRef.getStomach()));
                                    i--;

                                }

                            }
                        }
                    }
                    break;
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
        }
        while (true);

    }

    //Метод добавление еды в миску.
    public static int addFood(int catBowl, Scanner in) {
        int foodToAdd;
        System.out.print("Сколько корма вы хотите положить (1-1000): ");
        foodToAdd = writeIntPlease(in);
        if ((foodToAdd + catBowl) > 1000) {
            System.out.println("Упс. Перебор. Остатки канули в небытие.");
            return 1000;
        } else {
            return foodToAdd + catBowl;
        }
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
