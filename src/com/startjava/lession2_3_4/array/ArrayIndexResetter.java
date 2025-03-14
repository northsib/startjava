package com.startjava.lession2_3_4.array;

import java.util.Random;

public class ArrayIndexResetter {
    public static void main(String[] args) {
        int[] indexes = {-1, 15, 0, 14};

        float[] floats1 = createArray();
        resetExceedingFloats(floats1,indexes[0]);
        float[] floats2 = createArray();
        resetExceedingFloats(floats2,indexes[1]);
        float[] floats3 = createArray();
        resetExceedingFloats(floats3, indexes[2]);
        float[] floats4 = createArray();
        resetExceedingFloats(floats4, indexes[3]);
    }

    public static float[] createArray() {
        float[] floats = new float[15];
        Random random = new Random();
        for (int i = 0; i < floats.length; i++) {
            floats[i] = random.nextFloat();
        }
        System.out.println("Исходный массив: ");
        printArray(floats);
        return floats;
    }

    public static void resetExceedingFloats (float[] floats, int index) {
        if (index < 0 || index >= floats.length) {
            System.out.println("Ошибка: индекс массива выходит за пределы массива\n");
            return;
        }
        float limit = floats[index];
        int zeroCount = 0;
        for (int i = 0; i < floats.length; i++) {
            if (floats[i] > limit) {
                floats[i] = 0;
                zeroCount++;
            }
        }
        System.out.println("Измененный массив: ");
        printArray(floats);
        System.out.printf("Значение ячейки по переданному индексу: %.3f%n", floats[index]);
        System.out.println("Количество обнуленных ячеек - " + zeroCount);
        System.out.println();
    }

    public static void printArray (float[] floats) {
        for (int i = 0; i < floats.length; i++) {
            if (i == 8) {
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
