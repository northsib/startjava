package com.startjava.lession2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Console.displayHeader("Реверс массива");
        int[][] numbers = new int[][]{{}, null, {6, 8, 9, 1}, {13, 8, 5, 3, 2, 1, 1}};
        reverseArray(numbers);

        Console.displayHeader("Вычисление факториала значений массива");
        numbers = new int[][]{{}, null, {8, 0, 9}, {-3, 1, 7, 13}, {-22, 0}};
        calculateFactorial(numbers);

        Console.displayHeader("Обнуление значений массива, превышающих заданное значение");
        int[] indexes = {-1, 15, 0, 14};
        resetExceedingValues(indexes);

        Console.displayHeader("Вывод символов в виде треугольника");
        char[][] symbols = new char[][] {{'0', '9'}, {'/', '!'}, {'A', 'J'}};
        boolean[] ascendings = new boolean[] {true, false, false};
        drawTriangle(symbols, ascendings);

        Console.displayHeader("Заполнение массива уникальными значениями");
        int[][] segments = new int[][] {{-30, -10}, {10, 50}, {-34, -34}, {-1, 2}, {5, -8}};
        int[] numbersPerLine = new int[] {23, 10, 0, -3, 2};
        fillUniqueNumbers(segments, numbersPerLine);


        Console.displayHeader("Вывод текста с эффектом печатной машинки");
        String[] texts = {
                "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n- James Gosling",
                "Чтобы написать чистый код, мы сначала пишем грязный код, " +
                        "затем рефакторим его.\n- Robert Martin",
                null,
                ""
        };
        typewriterEffect(texts);
    }

    public static void reverseArray(int[][] numbers) {
        for (int[] nums : numbers) {
            int[] reversed = Arrays.reverse(nums);
            Console.printReversed(nums, reversed);
        }
    }

    public static void calculateFactorial(int[][] numbers) {
        for (int[] nums : numbers) {
            long[] factorials = Arrays.factorials(nums);
            Console.printFactorial(nums, factorials);
        }
    }

    public static void fillUniqueNumbers(int[][] segments, int[] numbersPerLine) {
        for (int i = 0; i < segments.length; i++) {
            int index = 0;
            int[] unique = Arrays.fill(segments[i][index], segments[i][index + 1], numbersPerLine[i]);
            Console.printLines(unique, numbersPerLine[i]);
        }
    }

    public static void resetExceedingValues(int[] indexes) {
        for (int index : indexes) {
            float[][] values = Arrays.createAndReset(index);
            Console.printFloatsLines(values, index);
        }
    }

    public static void drawTriangle(char[][] symbols, boolean[] ascendings) {
        for (int i = 0; i < symbols.length; i++) {
            int index = 0;
            StringBuilder triangle = Arrays.triangle(symbols[i][index], symbols[i][index + 1], ascendings[i]);
            Console.draw(triangle);
        }
    }

    public static void typewriterEffect(String[] texts) throws InterruptedException {
        for (String text : texts) {
            String result = Arrays.typewriter(text);
            Console.printTypewriterEffect(result);
        }
    }
}


//Scanner scanner = new Scanner(System.in);
//String userChoose = "yes";
//String[] mainMenu = {
//        "1. Реверс массива", "2. Вычисление факториала значений массива"};
//        while (userChoose.equals("yes")) {
//        System.out.print("Введите номер функции, которую хотите выполнить: ");
//
//        }
