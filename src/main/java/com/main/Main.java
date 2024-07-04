package com.main;

import com.lesson8.Lesson8;

public class Main {
    public static void main(String[] args) {

        Lesson8 lesson8 = new Lesson8();

        lesson8.TEST_DATA.forEach(lesson8::checkArray);
    }
}
