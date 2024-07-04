package com.lesson7.task1;

//Класс Кот наследник от Животное
public class Cat extends Animal {

    //Поле сытости
    private boolean fullness;
    //Поле для подсчета
    private static int catCount = 0;
    //Поле ограничения на бега
    private final int maxRunLength = 200;

    //Конструкторы класса
    public Cat() {
        super();
        fullness = false;
        catCount++;
    }

    public Cat(String name) {
        super(name);
        fullness = false;
        catCount++;
    }

    //GET и SET
    protected boolean isFullness() {
        return fullness;
    }

    protected void setFullness(boolean fullness) {
        this.fullness = fullness;
    }

    protected static int getCatCount() {
        return catCount;
    }


    //Изменяем метод run
    @Override
    protected void run(int length) {
        if (length <= maxRunLength) {
            super.run(length);
        } else {
            System.out.println(getName() + " не может бежать так далеко");
        }
    }

    //Изменяем метод swim
    @Override
    protected void swim(int length) {
        System.out.println(getName() + " не умеет плавать");
    }


}