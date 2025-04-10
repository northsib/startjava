package com.startjava.lession1.final_;

public class GuessNumberGame { 
    public static void main(String[] args) {
        int numberToGuess = 20;
        int inputNumber = 15;
        if ((numberToGuess < 1 || numberToGuess > 100) || (inputNumber < 1 || inputNumber > 100)) {
            System.out.println("Загаданное число лежит в диапазоне от 1 до 100");
            return;
        } 
        while (inputNumber != numberToGuess) {
            if (inputNumber > numberToGuess) {
                System.out.println(inputNumber + " больше, чем загаданное число");
                inputNumber--;
            } else if (inputNumber < numberToGuess) {
                System.out.println(inputNumber + " меньше, чем загаданное число");
                inputNumber++;
            }
        }
        System.out.println("Вы победили!");
    }
}