package io.github.alexwu727.utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void printArray_WithIntArrayParameter() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Printer.printArray(arr);
        assertEquals("1, 2, 3, 4, 5" + "\n", outContent.toString());
    }

    @Test
    void printArray_WithStringAndIntArrayParameter() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Printer.printArray("arr", arr);
        assertEquals("arr: 1, 2, 3, 4, 5" + "\n", outContent.toString());
    }

    @Test
    void printArray_WithStringAndIntMatrixParameter() {
        int[][] arr = new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}};
        Printer.printArray("arr", arr);
        assertEquals("""
                arr:\s
                1, 2, 3, 4, 5
                6, 7, 8, 9, 10
                """, outContent.toString());
    }
}