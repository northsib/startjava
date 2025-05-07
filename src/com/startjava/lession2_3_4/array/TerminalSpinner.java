package com.startjava.lession2_3_4.array;

import java.util.Random;

public class TerminalSpinner {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    private static final char[] SPINNER_ELEMENTS = {'-', '\\', '|', '/'};
    private static final int SPINNER_ITERATIONS = 7;
    private static final int SPINNER_SPEED = 250;

    public static void main(String[] args) throws InterruptedException {
        showAnimation();
    }

    private static void showAnimation() throws InterruptedException {
        StringBuilder output = new StringBuilder("Hacking: ");
        int outputLength = output.length();
        for (int i = 0; i < SPINNER_ITERATIONS; i++) {
            for (char ch : SPINNER_ELEMENTS) {
                output.setLength(outputLength);
                output.append(ch);
                System.out.print("\r" + output);
                System.out.flush();
                Thread.sleep(SPINNER_SPEED);
            }
        }
        output.setLength(outputLength);
        System.out.print("\r" + output + showResult());
    }

    private static String showResult() {
        Random r = new Random();
        String access = determine(r);
        return (access.contains("granted") ? ANSI_GREEN : ANSI_RED) + access + ANSI_RESET;
    }

    private static String determine(Random r) {
        int randomInt = r.nextInt(0, 101);
        return "Access" + (randomInt > 70 ? " granted!" : " denied!");
    }
}
