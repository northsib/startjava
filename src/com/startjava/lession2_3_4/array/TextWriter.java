package com.startjava.lession2_3_4.array;

import java.util.Arrays;

public class TextWriter {
    public static void main(String[] args) {
        String[] texts = {
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
                if (cleanWord.length() == 0) {
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
        int minLength = shortest.length();
        int maxLength = longest.length();

        // Создаем StringBuilder для результата
        StringBuilder result = new StringBuilder();

        // Проходим по исходному тексту, разделяя на части
        int start = 0;
        while (start < text.length()) {
            // Находим начало и конец слова или знака препинания
            int end = start;
            while (end < text.length() && !Character.isWhitespace(text.charAt(end))) {
                end++;
            }

            String part = text.substring(start, end);

            // Убираем знаки препинания из части для проверки
            String cleanPart = part.replaceAll("\\p{Punct}", "");

            // Проверяем длину слова
            if (cleanPart.length() >= minLength && cleanPart.length() <= maxLength) {
                result.append(part.toUpperCase());
            } else {
                result.append(part.toLowerCase());
            }

            // Переходим к следующей части
            start = end;
            while (start < text.length() && Character.isWhitespace(text.charAt(start))) {
                result.append(text.charAt(start));
                start++;
            }
        }

        return result.toString();
    }


}

