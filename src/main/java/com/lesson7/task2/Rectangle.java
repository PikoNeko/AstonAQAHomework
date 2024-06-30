package com.lesson7.task2;

public class Rectangle extends GeometricShapes {

    //Поля класса
    private double sideA;
    private double sideB;

    //Конструкторы класса
    public Rectangle(){
        sideA = 30d;
        sideB = 30d;
    }

    public Rectangle(double sideA, double sideB){
        this.sideA = sideA;
        this.sideB = sideB;
    }

    //Get и Set
    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    //Методы класса
    public void perimeterCalculation() {
        setPerimeter(sideA * 2 + sideB * 2);
    }

    @Override
    public void areaCalculation() {
        setArea(sideA * sideB);
    }

    @Override
    public void printInfo() {
        String message = String.format("Сторона a - %f \nСторона b - %f", sideA, sideB);
        System.out.println(message);
        super.printInfo();
    }


}
