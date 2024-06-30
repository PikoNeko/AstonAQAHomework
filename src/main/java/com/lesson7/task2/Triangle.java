package com.lesson7.task2;

public class Triangle extends GeometricShapes {

    private double sideA;
    private double sideB;
    private double sideC;

    //Конструкторы класса
    public Triangle() {
        sideA = 30d;
        sideB = 30d;
        sideC = 30d;
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
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


    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }

    //Методы класса
    @Override
    public void perimeterCalculation() {
        setPerimeter(sideA + sideB + sideC);
    }

    @Override
    public void areaCalculation() {
        if (getPerimeter() == 0) {
            setPerimeter(sideA + sideB + sideC);
        }
        double halfPerimeter = getPerimeter() / 2;
        setArea(Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC)));
    }

    @Override
    public void printInfo() {
        String message = String.format("Сторона а - %f \nСторона b - %f \nСторона c - %f", sideA, sideB, sideC);
        System.out.println(message);
        super.printInfo();
    }
}
