package com.lesson9;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import com.myInterfaces.WriteChecks;
import net.datafaker.Faker;

//Класс телефонного справочника
public class PhoneBook implements WriteChecks {

    //Список фамилий и телефонных номеров
    private final HashMap<String, HashSet<String>> RECORDS = new HashMap<>();

    //Метод для поиска номера по фамилии
    public void get() {
        Scanner in = new Scanner(System.in);
        String lastName;
        System.out.print("Введите имя:");
        lastName = in.nextLine();
        if(RECORDS.get(lastName) != null) {
            RECORDS.get(lastName).forEach(number -> System.out.println("\t" + number));
            System.out.println();
        }
        else {
            System.out.println("Запись не найдена!\n");
        }
    }

    //Метод для добавления записи
    public void add() {

        Scanner in = new Scanner(System.in);
        String lastName, number;

        System.out.print("Введите имя:");
        lastName = in.nextLine();
        number = WriteChecks.numberCheck();
        //Нет ли уже такой фамилии
        if (RECORDS.containsKey(lastName)) {
            RECORDS.get(lastName).add(number);
        } else {
            RECORDS.put(lastName, new HashSet<>());
            RECORDS.get(lastName).add(number);
        }
        System.out.println();
    }

    //Метод добавления 10 записей в список, оставлю, легче будет проверять работу
    public void addRandomsToList() {
        Faker faker = new Faker();
        Random random = new Random();
        String keyRef;
        for (int i = 0; i < 10; i++) {
            keyRef = faker.name().lastName();
            RECORDS.put(keyRef, new HashSet<>());
            for (int j = 0; j < random.nextInt(3) + 1; j++) {
                RECORDS.get(keyRef).add(faker.phoneNumber().phoneNumber());
            }
        }
    }

    //Метод вывода всех записей, оставлю, легче будет проверять работу
    public void printRecords() {
        RECORDS.forEach((name, key) -> {
            System.out.println(name);
            key.forEach(number -> System.out.println("\t" + number));
        });
        System.out.println();
    }

}
