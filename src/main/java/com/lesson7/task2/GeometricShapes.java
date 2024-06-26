package com.lesson7.task2;

//Абстрактный класс геометрических фигур
public abstract class GeometricShapes implements GeometricalShapesActions {

    //Поля класса
    private double perimeter;
    private double area;
    private String backgroundColor;
    private String borderColor;


    //Get и Set
    protected double getPerimeter() {
        return perimeter;
    }

    protected void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    protected double getArea() {
        return area;
    }

    protected void setArea(double area) {
        this.area = area;
    }

    protected String getBackgroundColor() {
        return backgroundColor;
    }

    protected void setBackgroundColor() {
        System.out.println("Выберите цвет границ.");
        this.backgroundColor = setColor();
    }

    protected String getBorderColor() {
        return borderColor;
    }

    protected void setBorderColor() {
        System.out.println("Выберите цвет заливки.");
        this.borderColor = setColor();
    }

    //Метод вывода информации о фигурах
    protected void printInfo(){
        if(perimeter == 0) perimeterCalculation();
        if(area == 0) areaСalculation();
        String message = String.format("Периметр - %f \n" +
                "Площадь - %f \n" +
                "Цвет фона - %s \n" +
                "Цвет границ - %s", perimeter, area, backgroundColor, borderColor);
        System.out.println(message);
    }


}
