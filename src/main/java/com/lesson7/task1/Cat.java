package com.lesson7.task1;

//Класс Кот наследник от Животное
public class Cat extends Animal {

    private boolean fullness;
    private int stomach;

    //Конструкторы класса
    public Cat() {
        super();
        fullness = false;
        stomach = 0;
    }

    public Cat(String name) {
        super(name);
        fullness = false;
        stomach = 0;
    }

    //GET и SET
    protected boolean isFullness() {
        return fullness;
    }

    protected void setFullness(boolean fullness) {
        this.fullness = fullness;
    }


    protected int getStomach() {
        return stomach;
    }

    protected void setStomach(int stomach) {
        this.stomach = stomach;
    }

    //Изменяем метод run
    @Override
    protected void run(int length) {
        if (length <= 200) {
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

    //Метод траты котом калорий
    protected void workout() {
        if (this.stomach < 5) {
            setStomach(0);
            setFullness(false);
        } else {
            this.stomach -= 5;
        }
    }
}
