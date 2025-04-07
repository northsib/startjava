package com.startjava.lession2_3_4.calculator;

import java.util.Scanner; 

public class CalculatorTest { 
    public static void main(String[] args) throws InvalidInputExceprion {
        Scanner scanner = new Scanner(System.in);
        String userChoose = "yes";

        while (userChoose.equals("yes")) {
            System.out.println("Введите выражение из 3 аргументов (например: 2 + 1)");
            String[] correctExpression = Calculator.makeCorrectExpression(scanner.nextLine());
            double result = Calculator.calculate(correctExpression);
            Calculator.printResult(correctExpression, result);
            System.out.println("Хотите продолжить вычисления? [yes/no]:");
            userChoose = scanner.nextLine().toLowerCase();
            while (true) {
                if (!userChoose.equals("yes") && !userChoose.equals("no")) {
                    System.out.println("Введите корректный ответ [yes/no]:");
                    userChoose = scanner.nextLine().toLowerCase();
                } else {
                    break;
                }
            }
        }
        scanner.close();
    }
}
