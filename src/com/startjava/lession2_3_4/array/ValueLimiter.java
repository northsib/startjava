package com.startjava.lession2_3_4.array;

import java.util.Random;

public class ValueLimiter {
    public static void main(String[] args) {
        int[] indexes = {-1, 15, 0, 14};

        for (int index : indexes) {
            float[] floats = create();
            float[] changed = resetExceedFloats(floats, index);
            printResult(floats, changed, index);
        }
    }

    private static float[] create() {
        float[] floats = new float[15];
        Random random = new Random();
        for (int i = 0; i < floats.length; i++) {
            floats[i] = random.nextFloat();
        }
        return floats;
    }

    private static float[] resetExceedFloats(float[] floats, int index) {
        if (index < 0 || index >= floats.length) {
            return null;
        }
        float[] changed = new float[floats.length];
        float limit = floats[index];
        for (int i = 0; i < floats.length; i++) {
            if (floats[i] > limit) {
                changed[i] = 0;
                continue;
            }
            changed[i] = floats[i];
        }
        return changed;
    }

    private static void printResult(float[] floats, float[] changed, int index) {
        if (changed == null) {
            System.out.println("\nОшибка: индекс массива выходит за пределы массива");
            return;
        }
        System.out.print("\nИсходный массив: ");
        print(floats);
        System.out.print("Измененный массив: ");
        print(changed);
        System.out.printf("Значение ячейки по переданному индексу: %.3f%n", floats[index]);
        int zeroCounter = 0;
        for (float value : changed)
            if (value == 0) {
                zeroCounter++;
            }
        System.out.println("Количество обнуленных ячеек - " + zeroCounter);
    }

    private static void print(float[] floats) {
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