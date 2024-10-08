package com.minesweeper.util;

import org.junit.jupiter.api.Test;
import org.minesweeper.exception.InvalidGridSizeException;
import org.minesweeper.exception.InvalidMineCountException;
import org.minesweeper.util.GameValidation;

import static org.junit.jupiter.api.Assertions.*;

class GameValidationTest {

    @Test
    void testValidGridSize() {
        assertDoesNotThrow(() -> GameValidation.validateGridSize(5)); // Valid case
        assertDoesNotThrow(() -> GameValidation.validateGridSize(20)); // Valid case at max
    }

    @Test
    void testInvalidGridSizeThrowsException() {
        // Test for invalid grid sizes
        Exception exception1 = assertThrows(InvalidGridSizeException.class, () -> GameValidation.validateGridSize(1));
        assertEquals("Grid size must be between 2 and 20", exception1.getMessage());

        Exception exception2 = assertThrows(InvalidGridSizeException.class, () -> GameValidation.validateGridSize(21));
        assertEquals("Grid size must be between 2 and 20", exception2.getMessage());
    }

    @Test
    void testValidMineCount() {
        // For a 5x5 grid (25 cells) with a max mine percentage of 35%
       // int maxMines = (int) (25 * 0.35); // Should be 8
        assertDoesNotThrow(() -> GameValidation.validateMineCount(5, 8)); // Valid case
        assertDoesNotThrow(() -> GameValidation.validateMineCount(5, 1)); // Valid case with 1 mine
    }

    @Test
    void testInvalidMineCountThrowsException() {
        // For a 5x5 grid (25 cells) with a max mine percentage of 35%
        int maxMines = (int) (25 * 0.35); // Should be 8

        // Test for invalid mine counts
        Exception exception1 = assertThrows(InvalidMineCountException.class, () -> GameValidation.validateMineCount(5, 0));
        assertEquals("Mine count must be greater than zero and no more than " + maxMines + " for the given grid size.", exception1.getMessage());

        Exception exception2 = assertThrows(InvalidMineCountException.class, () -> GameValidation.validateMineCount(5, 9)); // Too many mines
        assertEquals("Mine count must be greater than zero and no more than " + maxMines + " for the given grid size.", exception2.getMessage());
    }
}