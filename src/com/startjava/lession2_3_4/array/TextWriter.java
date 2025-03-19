package com.startjava.lession2_3_4.array;

import java.util.Arrays;

public class TextWriter {
    public static void main(String[] args) {
        String[] texts = {
                "Тестируем массив просто я так хочу",
                "Java - это C++, из которого убрали все пистолеты, ножи и дубинки. - James Gosling",
                "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его. - Robert Martin",
                "null",
                ""
        };

        for (String text : texts) {
            System.out.println("Исходный текст: " + text);
            String result = processText(text);
            System.out.println("Обработанный текст: " + result);
            System.out.println("--------------------------------------");
            System.out.println();
        }
    }

    private static String processText(String text) {
        String[] words = text.split(" ");
        if (words.length == 0) {
            return null;
        }
        String longest = words[0];
        String shortest = words[0];

        for (String word : words) {
            String cleanWord = word.replaceAll("\\p{Punct}", "");
            if (cleanWord.length() < shortest.length()) {
                if (cleanWord.isEmpty()) {
                    continue;
                }
                shortest = cleanWord;
            }
            if (cleanWord.length() > longest.length()) {
                longest = cleanWord;
            }
        }
        System.out.println(shortest);
        System.out.println(longest);
        System.out.println(Arrays.toString(words));

        int shortIndex = returnIndex(words, shortest);
        int longIndex = returnIndex(words, longest);

        StringBuilder result = new StringBuilder();

        int start = Math.min(shortIndex, longIndex);
        int end = Math.max(shortIndex, longIndex);
        for (int i = 0; i < words.length; i++) {
            if (i < start || i > end) {
                result.append(words[i]).append(" ");
            }
            if (i >= start && i <= end) {
                result.append(words[i].toUpperCase()).append(" ");
            }
        }
        return result.toString();
    }

    private static int returnIndex(String[] words, String word) {
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].contains(word)) {
                index = i;
            }
        }
        return index;
    }
}

