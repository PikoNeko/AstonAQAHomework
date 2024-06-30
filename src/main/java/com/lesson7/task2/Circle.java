package com.lesson7.task2;

public class Circle extends GeometricShapes {

    //Переменные класса
    private double radius;

    //Конструкторы класса
    public Circle(){
        radius = 30d;
    }

    public Circle(float radius){

        this.radius = radius;
    }

    //Get и Set
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //Методы класса
    @Override
    public void perimeterCalculation() {
        setPerimeter(2*Math.PI * radius);
    }

    @Override
    public void areaCalculation() {
        setArea(Math.PI * Math.pow(radius, 2));
    }

    @Override
    protected void printInfo(){
        System.out.println("Радиус - " + radius + "\n");
        super.printInfo();
    }
}
