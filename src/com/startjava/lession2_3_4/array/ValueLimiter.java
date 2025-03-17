package com.startjava.lession2_3_4.array;

import java.util.Random;

public class ValueLimiter {
    public static void main(String[] args) {
        int[] indexes = {-1, 15, 0, 14};

        for (int index : indexes) {
            float[] floats = create();
            resetExceedingFloats(floats, index);
        }
    }

    public static float[] create() {
        float[] floats = new float[15];
        Random random = new Random();
        for (int i = 0; i < floats.length; i++) {
            floats[i] = random.nextFloat();
        }
        return floats;
    }

    public static void resetExceedingFloats(float[] floats, int index) {
        if (index < 0 || index >= floats.length) {
            System.out.println("Ошибка: индекс массива выходит за пределы массива\n");
            return;
        }
        System.out.println("Исходный массив: ");
        print(floats);
        float limit = floats[index];
        int zeroCount = 0;
        for (int i = 0; i < floats.length; i++) {
            if (floats[i] > limit) {
                floats[i] = 0;
                zeroCount++;
            }
        }
        System.out.println("\nИзмененный массив: ");
        print(floats);
        System.out.printf("\nЗначение ячейки по переданному индексу: %.3f%n", floats[index]);
        System.out.println("Количество обнуленных ячеек - " + zeroCount);
        System.out.println();
    }

    public static void print(float[] floats) {
        for (int i = 0; i < floats.length; i++) {
            if (i % 8 == 0) {
                System.out.println();
            }
            System.out.printf("%.3f%s", floats[i], "");
            if (i < (floats.length - 1)) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}