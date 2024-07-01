package com.lesson7.task1;

public class Bowl {
    private static final int maxFood = 2147483647;
    private static int catFood = 0;

    protected static int getCatFood() {
        return catFood;
    }

    protected static void setCatFood(int catFood) {
        if (Bowl.catFood + catFood < maxFood)
            Bowl.catFood = catFood;
        else {
            System.out.println("Упс. Перебор. Остатки канули в небытие.");
            Bowl.catFood = maxFood;
        }
    }
}
