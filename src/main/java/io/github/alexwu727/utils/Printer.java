package io.github.alexwu727.utils;

public class Printer {
    public static void printArray(String name, int[] array) {
        System.out.print(name + ": ");
        for (int i : array) {
            if (i == array[array.length - 1])
                System.out.print(i);
            else
                System.out.print(i + ", ");
        }
        System.out.println();
    }
}
