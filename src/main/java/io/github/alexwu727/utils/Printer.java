package io.github.alexwu727.utils;

public class Printer {
    public static void printArray(int[] array) {
        for (int i : array) {
            if (i == array[array.length - 1])
                System.out.print(i);
            else
                System.out.print(i + ", ");
        }
        System.out.println();
    }
    public static void printArray(String name, int[] array) {
        System.out.print(name + ": ");
        printArray(array);
    }

    public static void printArray(String name, int[][] array) {
        System.out.println(name + ": ");
        for (int[] row : array) {
            printArray(row);
        }
    }
}
