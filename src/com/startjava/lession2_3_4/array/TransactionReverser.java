package com.startjava.lession2_3_4.array;

import java.util.Arrays;

public class TransactionReverser {
    public static void main(String[] args) {
        int[][] transactions =
                new int[][] {{}, null, {5}, {6, 8, 9, 1}, {13, 8, 5, 3, 2, 1, 1}};
        display(transactions);
    }

    private static int[] reverse(int[] transactions) {
        if (transactions == null || transactions.length == 0) {
            return null;
        }
        int[] reversed = Arrays.copyOf(transactions, transactions.length);
        for (int i = 0; i < reversed.length; i++) {
            reversed[i] = transactions[transactions.length - i - 1];
        }
        return reversed;
    }

    private static void display(int[][] transactions) {
        for (int[] transaction : transactions) {
            if (transaction == null) {
                System.out.println("Передан массив null");
                continue;
            }
            if (transaction.length == 0) {
                System.out.println("Передан пустой массив");
                continue;
            }
            int[] reversed = reverse(transaction);
            System.out.println("Исходные транзакции: " + Arrays.toString(transaction));
            System.out.println(" В обратном порядке: " + Arrays.toString(reversed));
        }
    }
}
