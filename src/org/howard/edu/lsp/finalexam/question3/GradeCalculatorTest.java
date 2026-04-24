package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradeCalculatorTest {

    // 1. One test for average()
    @Test
    public void testAverageCalculation() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals(80.0, calculator.average(70, 80, 90), 0.0001);
    }

    // 2. One test for letterGrade()
    @Test
    public void testLetterGrade() {
        GradeCalculator calculator = new GradeCalculator();
        assertEquals("B", calculator.letterGrade(85.5));
    }

    // 3. One test for isPassing()
    @Test
    public void testIsPassing() {
        GradeCalculator calculator = new GradeCalculator();
        assertTrue(calculator.isPassing(70.0));
        assertFalse(calculator.isPassing(55.0));
    }

    // 4a. Boundary-value test (Minimum boundary)
    @Test
    public void testMinimumBoundaryScores() {
        GradeCalculator calculator = new GradeCalculator();
        // Testing the absolute lowest valid scores
        assertEquals(0.0, calculator.average(0, 0, 0), 0.0001);
        assertEquals("F", calculator.letterGrade(0.0));
    }

    // 4b. Boundary-value test (Maximum boundary)
    @Test
    public void testMaximumBoundaryScores() {
        GradeCalculator calculator = new GradeCalculator();
        // Testing the absolute highest valid scores
        assertEquals(100.0, calculator.average(100, 100, 100), 0.0001);
        assertEquals("A", calculator.letterGrade(100.0));
    }

    // 5a. Exception test using assertThrows() (Negative boundary)
    @Test
    public void testNegativeScoreThrowsException() {
        GradeCalculator calculator = new GradeCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(-5, 80, 90);
        });
        assertEquals("Score must be between 0 and 100", exception.getMessage());
    }

    // 5b. Exception test using assertThrows() (Over 100 boundary)
    @Test
    public void testScoreOver100ThrowsException() {
        GradeCalculator calculator = new GradeCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.average(105, 80, 90);
        });
        assertEquals("Score must be between 0 and 100", exception.getMessage());
    }
}