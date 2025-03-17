package com.startjava.lession2_3_4.array;

public class TriangleDrawer {
    public static void main(String[] args) {
        String[] triangle = create('0', '9', true);
        print1(triangle);
        triangle = create('/', '!', false);
        print1(triangle);
        triangle = create('A', 'J', true);
        print1(triangle);
    }

    private static String[] create(char start, char end, boolean ascending) {
        if (start > end) {
            return new String[]{"\nОшибка: левая граница (" + start + ") > (" + end + ")\n"};
        }

        int triangleHeight = end - start + 1;
        char startPrint = ascending ? end : start;
        String[] triangle = new String[triangleHeight];
        StringBuilder creator = new StringBuilder();
        for (int i = 0; i < triangleHeight; i++) {
            char currentChar = (char) (ascending ? startPrint - i : startPrint + i);
            creator.append(" ".repeat(Math.max(0, (triangleHeight - 1) - i)))
                        .append(String.valueOf(currentChar).repeat(2 * i + 1));
            triangle[i] = String.valueOf(creator);
            creator = new StringBuilder();
        }
        return triangle;
    }

    private static void print1(String[] triangle) {
        for (String s : triangle) {
            System.out.println(s);
        }
    }
}


