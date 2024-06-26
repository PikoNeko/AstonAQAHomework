package com.lesson7.task1;

//Класс Животные
public class Animal {

    //Поля класса
    private String name;

    //Конструкторы класса
    public Animal() {
        this.name = "Животное";
    }

    public Animal(String name) {
        this.name = name;
    }

    //Get и Set
    protected String getName() {

        return name;
    }

    protected void setName(String name) {

        this.name = name;
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
