package com.lesson7.task1;

public class Dog extends Animal {

    //Поле для подсчета
    private static int dogCount = 0;
    //Поле ограничения бега
    private final int maxRunLength = 500;
    //Поле ограничения плавания
    private final int maxSwimLength = 10;

    //Конструкторы класса
    public Dog() {
        super();
        dogCount++;
    }

    public Dog(String name) {
        super(name);
        dogCount++;
    }

    //Get и Set
    protected static int getDogCount(){
        return dogCount;
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
        if (length <= maxSwimLength) {
            super.swim(length);
        } else {
            System.out.println(getName() + " не может плыть так далеко");
        }
    }
}
