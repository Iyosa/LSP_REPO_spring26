package org.howard.edu.lsp.assignment6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit 5 test suite for IntegerSet Assignment 6.
 * Each method includes both a Normal case and required Edge cases.
 */
public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    @DisplayName("Test add: normal case + duplicate values")
    void testAdd() {
        set1.add(1);
        Assertions.assertEquals(1, set1.length()); // Normal case
        set1.add(1); 
        Assertions.assertEquals(1, set1.length()); // Edge case: duplicate values
    }

    @Test
    @DisplayName("Test remove: normal case + value not present")
    void testRemove() {
        set1.add(1);
        set1.add(2);
        set1.remove(1); // Normal case
        Assertions.assertFalse(set1.contains(1)); 
        set1.remove(5); // Edge case: value not present
        Assertions.assertEquals(1, set1.length());
    }

    @Test
    @DisplayName("Test clear: normal case + empty set")
    void testClear() {
        set1.add(1);
        set1.clear(); // Normal case
        Assertions.assertTrue(set1.isEmpty()); 
        set1.clear(); // Edge case: clearing an already empty set
        Assertions.assertEquals(0, set1.length());
    }

    @Test
    @DisplayName("Test length: normal case + empty set")
    void testLength() {
        set1.add(1);
        set1.add(2);
        Assertions.assertEquals(2, set1.length()); // Normal case
        set1.clear();
        Assertions.assertEquals(0, set1.length()); // Edge case: empty set
    }

    @Test
    @DisplayName("Test equals: same elements different order + mismatch")
    void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        Assertions.assertTrue(set1.equals(set2)); // Edge case: same elements, different order
        set2.add(3);
        Assertions.assertFalse(set1.equals(set2)); // Edge case: mismatch
    }

    @Test
    @DisplayName("Test contains: normal case + value not present")
    void testContains() {
        set1.add(10);
        Assertions.assertTrue(set1.contains(10)); // Normal case
        Assertions.assertFalse(set1.contains(5)); // Edge case: value not present
    }

    @Test
    @DisplayName("Test largest: single element + empty exception")
    void testLargest() {
        set1.add(5);
        Assertions.assertEquals(5, set1.largest()); // Edge case: single element
        set1.add(10);
        Assertions.assertEquals(10, set1.largest()); // Normal case
        set1.clear();
        Assertions.assertThrows(IntegerSet.IntegerSetException.class, () -> {
            set1.largest(); // Edge case: empty set exception
        });
    }

    @Test
    @DisplayName("Test smallest: single element + empty exception")
    void testSmallest() {
        set1.add(10);
        Assertions.assertEquals(10, set1.smallest()); // Edge case: single element
        set1.add(5);
        Assertions.assertEquals(5, set1.smallest()); // Normal case
        set1.clear();
        Assertions.assertThrows(IntegerSet.IntegerSetException.class, () -> {
            set1.smallest(); // Edge case: empty set exception
        });
    }

    @Test
    @DisplayName("Test union: normal case + with empty set")
    void testUnion() {
        set1.add(1);
        set2.add(2);
        IntegerSet result = set1.union(set2);
        Assertions.assertTrue(result.contains(1) && result.contains(2)); // Normal case
        
        IntegerSet emptySet = new IntegerSet();
        IntegerSet result2 = set1.union(emptySet); 
        Assertions.assertEquals("[1]", result2.toString()); // Edge case: with empty set
    }

    @Test
    @DisplayName("Test intersect: normal case + no common elements")
    void testIntersect() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        Assertions.assertEquals("[2]", set1.intersect(set2).toString()); // Normal case
        
        set1.clear();
        set1.add(10);
        Assertions.assertTrue(set1.intersect(set2).isEmpty()); // Edge case: no common elements
    }

    @Test
    @DisplayName("Test diff: normal case + identical sets")
    void testDiff() {
        set1.add(1);
        set1.add(2);
        set2.add(1);
        set2.add(2);
        Assertions.assertTrue(set1.diff(set2).isEmpty()); // Edge case: identical sets
        
        set2.remove(1); // set2 is now [2]
        Assertions.assertEquals("[1]", set1.diff(set2).toString()); // Normal case
    }

    @Test
    @DisplayName("Test complement: normal case + disjoint sets")
    void testComplement() {
        set1.add(1);
        set2.add(1);
        set2.add(2);
        Assertions.assertEquals("[2]", set1.complement(set2).toString()); // Normal case
        
        set1.clear();
        set1.add(10); // set1={10}, set2={1, 2}
        Assertions.assertEquals("[1, 2]", set1.complement(set2).toString()); // Edge case: disjoint sets
    }

    @Test
    @DisplayName("Test isEmpty: empty vs non-empty")
    void testIsEmpty() {
        Assertions.assertTrue(set1.isEmpty()); // Edge case: empty
        set1.add(1);
        Assertions.assertFalse(set1.isEmpty()); // Normal case: non-empty
    }

    @Test
    @DisplayName("Test toString: normal case + empty set")
    void testToString() {
        set1.add(3);
        set1.add(1);
        set1.add(2);
        Assertions.assertEquals("[1, 2, 3]", set1.toString()); // Normal case
        
        set2.clear();
        // Edge case: empty set. (Verify if your toString returns "[]" or "[")
        Assertions.assertEquals("[]", set2.toString()); 
    }
}