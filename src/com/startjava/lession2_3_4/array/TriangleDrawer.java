package com.startjava.lession2_3_4.array;

public class TriangleDrawer {
    public static void main(String[] args) {
        print('0', '9', true);
        print('/', '!', false);
        print('A', 'J', false);
    }

    private static void print(char start, char end, boolean ascending) {
        if (start > end) {
            System.out.println("Ошибка: левая граница (" + (int) start + ") > правой (" + (int) end + ")\n");
            return;
        }
        int height = end - (start - 1);
        char startPrint = ascending ? end : start;

        for (int i = 0; i < height; i++) {
            char currentChar = (char) (ascending ? startPrint - i : startPrint + i);
            StringBuilder spaces = new StringBuilder();
            spaces.append(" ".repeat(Math.max(0, (height - 1) - i)));
            StringBuilder chars = new StringBuilder();
            chars.append(String.valueOf(currentChar).repeat(2 * i + 1));
            System.out.println(spaces + chars.toString());
        }
        System.out.println();
    }
}


