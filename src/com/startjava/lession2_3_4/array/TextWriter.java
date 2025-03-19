package com.startjava.lession2_3_4.array;

public class TextWriter {
    public static void main(String[] args) throws InterruptedException {
        String[] texts = {
                "Java - это C++, из которого убрали все пистолеты, ножи и дубинки. - James Gosling",
                "Чтобы написать чистый код, мы сначала пишем грязный код, " +
                        "затем рефакторим его. - Robert Martin",
                null,
                ""
        };

        for (String text : texts) {
            String result = processText(text);
            print(result);
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

    private static void print(String text) throws InterruptedException {
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

