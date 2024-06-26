package com.lesson7.task1;

public class Dog extends Animal {

    //Конструкторы класса
    public Dog() {
        super();
    }

    public Dog(String name) {
        super(name);
    }

    //Изменяем метод run
    @Override
    protected void run(int length) {
        if (length <= 500) {
            super.run(length);
        } else {
            System.out.println(getName() + " не может бежать так далеко");
        }
    }

    //Изменяем метод swim
    @Override
    protected void swim(int length) {
        if (length <= 10) {
            super.swim(length);
        } else {
            System.out.println(getName() + " не может плыть так далеко");
        }
    }
}
