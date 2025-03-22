package com.startjava.lession2_3_4.array;

import java.util.Arrays;

public class TypewriterEffect {
    public static void main(String[] args) throws InterruptedException {
        String[] texts = {
                "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.\n- James Gosling",
                "Чтобы написать чистый код, мы сначала пишем грязный код, " +
                        "затем рефакторим его.\n- Robert Martin",
                null,
                ""
        };

        for (String text : texts) {
            String result = processText(text);
            type(result);
            System.out.println();
        }
    }

    private static String processText(String text) {
        if (text == null || text.isEmpty()) {
            return null;
        }
        String[] words = text.split(" ");
        String longest = words[0];
        String shortest = words[0];
        int shortIndex = 0;
        int longIndex = 0;

        for (int i = 0; i < words.length; i++) {
            String cleanWord = words[i].replaceAll("\\p{P}", "");
            if (shortest.length() > cleanWord.length()) {
                if (cleanWord.isEmpty()) {
                    continue;
                }
                shortest = cleanWord;
                shortIndex = i;
            }
            if (longest.length() < cleanWord.length()) {
                longest = cleanWord;
                longIndex = i;
            }
        }
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

    private static void type(String text) throws InterruptedException {
        if (text == null || text.isEmpty()) {
            System.out.println("Передана пустая строка, либо null");
            return;
        }
        char[] chars = text.toCharArray();
        for (char symbols : chars) {
            System.out.print(symbols);
            Thread.sleep(100);
        }
        System.out.println();
    }
}

