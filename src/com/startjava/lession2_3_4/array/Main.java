package com.startjava.lession2_3_4.array;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Console.displayHeader("1. Реверс массива");
        int[][] numbers = new int[][]{{}, null, {6, 8, 9, 1}, {13, 8, 5, 3, 2, 1, 1}};
        reverseArray(numbers);

        Console.displayHeader("2. Вычисление факториала значений массива");
        numbers = new int[][]{{}, null, {8, 0, 9}, {-3, 1, 7, 13}, {-22, 0}};
        calculateFactorial(numbers);

        Console.displayHeader("3. Обнуление значений массива, превышающих заданное значение");
        int[] indexes = {-1, 15, 0, 14};
        resetExceedingValues(indexes);

        Console.displayHeader("4. Вывод символов в виде треугольника");
        char[][] symbols = new char[][] {{'0', '9'}, {'/', '!'}, {'A', 'J'}};
        boolean[] ascend = new boolean[] {true, false, false};
        drawTriangle(symbols, ascend);

        Console.displayHeader("5. Заполнение массива уникальными значениями");
        int[][] segments = new int[][] {{-30, -10}, {10, 50}, {-34, -34}, {-1, 2}, {5, -8}};
        int[] numbersPerLine = new int[] {23, 10, 0, -3, 2};
        fillUniqueNumbers(segments, numbersPerLine);

        Console.displayHeader("6. Вывод текста с эффектом печатной машинки");
        String[] texts = {
                "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n- James Gosling",
                "Чтобы написать чистый код, мы сначала пишем грязный код, " +
                        "затем рефакторим его.\n- Robert Martin",
                null,
                ""
        };
        typewriterEffect(texts);
    }

    private static void calculateFactorial(int[][] numbers) {
        for (int[] num : numbers) {
            long[] factorials = Arrays.factorials(num);
            Console.printFactorial(num, factorials);
            System.out.println();
        }
    }

    private static void drawTriangle(char[][] symbols, boolean[] ascend) {
        for (int i = 0; i < symbols.length; i++) {
            int index = 0;
            StringBuilder triangle = Arrays.triangle(symbols[i][index], symbols[i][index + 1], ascend[i]);
            Console.draw(triangle);
        }
    }

    private static void fillUniqueNumbers(int[][] segments, int[] numbersPerLine) {
        for (int i = 0; i < segments.length; i++) {
            int index = 0;
            int[] unique = Arrays.fill(segments[i][index], segments[i][index + 1], numbersPerLine[i]);
            Console.printIntegers(unique, numbersPerLine[i], "%3d");
            System.out.println();
        }
    }

    private static void resetExceedingValues(int[] indexes) {
        for (int index : indexes) {
            float[][] values = Arrays.resetFloatsByIndex(index);
            Console.displayValueLimiter(values, index);
            System.out.println();
        }
    }

    private static void reverseArray(int[][] numbers) {
        for (int[] number : numbers) {
            int[] reversed = Arrays.reverse(number);
            Console.displayBeforeAfter(number, reversed);
            System.out.println();
        }
    }

    private static void typewriterEffect(String[] texts) throws InterruptedException {
        for (String text : texts) {
            String result = Arrays.typewriter(text);
            Console.printTypewriterEffect(result);
            System.out.println();
        }
    }
}