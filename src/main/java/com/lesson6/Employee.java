package com.lesson6;

//Класс "Сотрудник"
public class Employee {

    //Поля класса сотрудник
    private String firstName;
    private String secondName;
    private String surName;
    private String jobPosition;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    //конструкторы класса
    public Employee() {
        this.firstName = "Иван";
        this.secondName = "Иванов";
        this.surName = "Иванович";
        this.jobPosition = "Работник на работе";
        this.email = "Ivanov@mail.ru";
        this.phoneNumber = "+7 (680) 629-79-15";
        this.salary = 15000;
        this.age = 33;
    }


    //Я не стал добавлять проверки, так как в задании нет ввода от пользователя.
    public Employee(String _firstName, String _secondName, String _surName, String _jobPosition, String _email,
                    String _phoneNumber, int _salary, int _age) {
        this.firstName = _firstName;
        this.secondName = _secondName;
        this.surName = _surName;
        this.jobPosition = _jobPosition;
        this.email = _email;
        this.phoneNumber = _phoneNumber;
        this.salary = _salary;
        this.age = _age;
    }


    //GET и SET для полей
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }


    public String getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    //метод вывода информации о сотруднике
    public void print() {
        System.out.println(
                "Сотрудник:" + "\n" + "ФИО: " + secondName + " " + firstName + " " + surName + "\n" +
                        "Должность: " + jobPosition + "\n" + "Email: " + email + "\n" + "Телефон: " + phoneNumber + "\n" +
                        "Зарплата: " + salary + "\n" + "Возраст: " + age + "\n");
    }

}
