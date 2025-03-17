package com.startjava.lession2_3_4.array;

public class TriangleDrawer {
    public static void main(String[] args) {
        draw(create('0', '9', true));
        draw(create('/', '!', false));
        draw(create('A', 'J', false));
    }

    private static StringBuilder create(char start, char end, boolean ascending) {
        if (start > end) {
            System.out.println("Ошибка: левая граница (" + start + ") > (" + end + ")\n");
            return null;
        }

        int triangleHeight = end - start + 1;
        char startPrint = ascending ? end : start;

        StringBuilder triangle = new StringBuilder();
        for (int i = 0; i < triangleHeight; i++) {
            char currentChar = (char) (ascending ? startPrint - i : startPrint + i);
            triangle.append(" ".repeat(Math.max(0, (triangleHeight - 1) - i)))
                    .append(String.valueOf(currentChar).repeat(2 * i + 1))
                    .append("\n");
        }
        return triangle;
    }

    private static void draw(StringBuilder triangle) {
        if (triangle == null) {
            return;
        }
        System.out.println(triangle);
    }
}