package org.howard.edu.lsp.assignment5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {
    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Test clear method")
    void testClear() {
        set1.add(1);
        set1.clear();
        Assertions.assertTrue(set1.isEmpty());
        Assertions.assertEquals(0, set1.length());
    }

    @Test
    @DisplayName("Test length method")
    void testLength() {
        set1.add(1);
        set1.add(2);
        Assertions.assertEquals(2, set1.length());
    }

    @Test
    @DisplayName("Test equals method")
    void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        Assertions.assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("Test largest and smallest exceptions")
    void testExceptions() {
        Assertions.assertThrows(IntegerSet.IntegerSetException.class, () -> {
            set1.largest();
        });
        Assertions.assertThrows(IntegerSet.IntegerSetException.class, () -> {
            set1.smallest();
        });
    }

    @Test
    @DisplayName("Test union")
    void testUnion() {
        set1.add(1);
        set2.add(2);
        IntegerSet result = set1.union(set2);
        Assertions.assertEquals("[1, 2]", result.toString());
    }

    @Test
    @DisplayName("Test intersection")
    void testIntersect() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        IntegerSet result = set1.intersect(set2);
        Assertions.assertEquals("[2]", result.toString());
    }

    @Test
    @DisplayName("Test difference")
    void testDiff() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        IntegerSet result = set1.diff(set2);
        Assertions.assertEquals("[1]", result.toString());
    }

    @Test
    @DisplayName("Test complement")
    void testComplement() {
        set1.add(1);
        set2.add(1);
        set2.add(2);
        IntegerSet result = set1.complement(set2);
        Assertions.assertEquals("[2]", result.toString());
    }

    @Test
    @DisplayName("Test toString sorting")
    void testToString() {
        set1.add(3);
        set1.add(1);
        set1.add(2);
        Assertions.assertEquals("[1, 2, 3]", set1.toString());
    }
}
