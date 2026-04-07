package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * A class that represents a mathematical set of integers using an ArrayList The
 * set cannot contain duplicates and supports standard set operations
 */
public class IntegerSet {

    /**
     * Internal storage for set elements
     */
    private ArrayList<Integer> elements;

    /**
     * Custom exception for IntegerSet operations Extends RuntimeException so
     * method signatures remain unchanged
     */
    public static class IntegerSetException extends RuntimeException {

        public IntegerSetException(String message) {
            super(message);
        }
    }

    /**
     * Default constructor that initializes an empty set
     */
    public IntegerSet() {
        this.elements = new ArrayList<Integer>();
    }

    /**
     * Clears all elements from the set
     */
    public void clear() {
        elements.clear();
    }

    /**
     * Returns the number of elements in the set
     *
     * @return the size of the set
     */
    public int length() {
        return elements.size();
    }

    /**
     * Returns true if the set contains no elements
     *
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /**
     * Adds an item to the set if it is not already present
     *
     * @param value the integer to add
     */
    public void add(int value) {
        if (!elements.contains(value)) {
            elements.add(value);
        }
    }

    /**
     * Removes an item from the set if it exists
     *
     * @param value the integer to remove
     */
    public void remove(int value) {
        elements.remove(Integer.valueOf(value));
    }

    /**
     * Returns true if the set contains the specified value
     *
     * @param value the integer to check for
     * @return true if the value is present
     */
    public boolean contains(int value) {
        return elements.contains(value);
    }

    /**
     * Returns the largest item in the set
     *
     * @return the maximum integer in the set
     * @throws IntegerSetException if the set is empty
     */
    public int largest() {
        if (elements.isEmpty()) {
            throw new IntegerSetException("IntegerSetException: Largest called on empty set.");
        }
        return Collections.max(elements);
    }

    /**
     * Returns the smallest item in the set
     *
     * @return the minimum integer in the set
     * @throws IntegerSetException if the set is empty
     */
    public int smallest() {
        if (elements.isEmpty()) {
            throw new IntegerSetException("IntegerSetException: Smallest called on empty set.");
        }
        return Collections.min(elements);
    }

    /**
     * Returns true if both sets contain exactly the same elements The
     * comparison is order-independent.
     *
     * * @param b the IntegerSet to compare with
     * @return true if the sets are equal, false otherwise
     */
    public boolean equals(IntegerSet b) {
        // Check if the lengths are different
        if (this.length() != b.length()) {
            return false;
        }

        // Check if every element in this set is present in the other set
        for (int num : this.elements) {
            if (!b.contains(num)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

    /**
     * Returns a new set containing all elements in either set
     *
     * @param intSetb the set to union with
     * @return a new IntegerSet representing the union
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int num : this.elements) {
            result.add(num);
        }
        for (int num : intSetb.elements) {
            result.add(num);
        }
        return result;
    }

    /**
     * Returns a new set containing only elements common to both sets
     *
     * @param intSetb the set to intersect with
     * @return a new IntegerSet representing the intersection
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int num : this.elements) {
            if (intSetb.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    /**
     * Returns a new set containing elements in the current set but not in b
     *
     * @param intSetb the set to differentiate with
     * @return a new IntegerSet representing the difference
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int num : this.elements) {
            if (!intSetb.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    /**
     * Returns a new set containing elements in b but not in the current set
     *
     * @param intSetb the set to find the complement of
     * @return a new IntegerSet representing the complement
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        for (int num : intSetb.elements) {
            if (!this.contains(num)) {
                result.add(num);
            }
        }
        return result;
    }

    /**
     * Returns a string representation of the set in ascending order Format: [1,
     * 2, 3]
     *
     * @return formatted string of the set
     */
    @Override
    public String toString() {
        ArrayList<Integer> sortedList = new ArrayList<>(elements);
        Collections.sort(sortedList);
        return sortedList.toString();
    }
}
