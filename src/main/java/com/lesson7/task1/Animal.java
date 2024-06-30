package com.lesson7.task1;

//Класс Животные
public abstract class Animal {

    //Поля класса
    private String name;
    //Поле для подсчета
    private static int animalCount = 0;

    //Конструкторы класса
    public Animal() {

        this.name = "Животное";
        animalCount++;
    }

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }


    //Get и Set
    protected String getName() {

        return name;
    }

    protected static int getAnimalCount() {
        return animalCount;
    }


    //Методы класса

    //Бежать
    protected void run(int length) {
        System.out.println(name + " пробежал " + length + " м");
    }

    //Плыть
    protected void swim(int length) {
        System.out.println(name + " проплыл " + length + " м");
    }

}
