package io.github.alexwu727.data_structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnionFindTest {
    private UnionFind unionFind;

    @BeforeEach
    void setUp() {
        unionFind = new UnionFind(5);
    }


    @Test
    void find() {
        assertEquals(0, unionFind.find(0));
        assertEquals(1, unionFind.find(1));
        assertEquals(2, unionFind.find(2));
        assertEquals(3, unionFind.find(3));
        assertEquals(4, unionFind.find(4));
    }

    @Test
    void union() {
        unionFind.union(0, 1);
        assertEquals(1, unionFind.find(0));
        assertEquals(1, unionFind.find(1));
        assertEquals(2, unionFind.find(2));
        assertEquals(3, unionFind.find(3));
        assertEquals(4, unionFind.find(4));

        unionFind.union(1, 2);
        assertEquals(1, unionFind.find(0));
        assertEquals(1, unionFind.find(1));
        assertEquals(1, unionFind.find(2));
        assertEquals(3, unionFind.find(3));
        assertEquals(4, unionFind.find(4));
    }
}