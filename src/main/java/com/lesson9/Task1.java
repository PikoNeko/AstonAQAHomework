package com.lesson9;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {

    public static void doTask() {
        setRandomList();
        uniqueWordsSearch();
    }

    //Массив слов
    private static final String[] WORD_MASS = {
            "Freedom", "Democracy", "Homeland", "SuperCitizen", "Duty",
            "Victory", "Unity", "Loyalty", "Service", "Protection"};
    //Список
    private static ArrayList<String> randomWordsArray = new ArrayList<>();

    //Метод рандомного наполнения списка
    private static void setRandomList() {
        randomWordsArray = Stream
                .generate(Task1::setRandomWord)
                .limit(20).
                collect(Collectors.toCollection(ArrayList<String>::new));
    }

    //Метод поиска уникальных слов
    private static void uniqueWordsSearch() {
        //Создаем map который будет состоять из Уникальных слов и их количества в wordMass с помощью Stream
        Map<String, Long> unics = randomWordsArray.stream()
                //Собираем список из уникальных слов и их количества
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //Выводим список
        unics.forEach((i, j) -> System.out.println(i + ": " + j));
    }

    //Метод возврата рандомного слова
    private static String setRandomWord() {
        return WORD_MASS[new Random().nextInt(WORD_MASS.length)];
    }

}
