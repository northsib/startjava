package com.startjava.lession2_3.guess;

public class Player {
    private String name;
    private int number;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public boolean setNumber(int number) {
        if (number < 1 || number > 100) {
            System.out.println("Ошибка: загаданное число должно быть от 1 до 100");
            return false;
        }
        this.number = number;
        return true;
    }
}