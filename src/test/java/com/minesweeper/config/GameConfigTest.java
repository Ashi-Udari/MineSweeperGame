package com.minesweeper.config;

import org.junit.jupiter.api.Test;
import org.minesweeper.config.GameConfig;
import org.minesweeper.exception.InvalidGridSizeException;
import org.minesweeper.exception.InvalidMineCountException;

import static org.junit.jupiter.api.Assertions.*;
import static org.minesweeper.util.GameValidation.MINE_PERCENTAGE;

public class GameConfigTest {

    @Test
    void testValidConfig() throws InvalidGridSizeException, InvalidMineCountException {
        GameConfig config = new GameConfig(4, 2);
        assertEquals(4, config.getGridSize(), "Grid size should be 4");
        assertEquals(2, config.getMineCount(), "Mine count should be 2");
    }
    @Test
    void testNullGridSize() {
        InvalidGridSizeException exception = assertThrows(InvalidGridSizeException.class, () -> {
            new GameConfig(null, 2);  // Null grid size
        });
        assertEquals("Grid size must not be null.", exception.getMessage());
    }

    @Test
    void testZeroGridSize() {
        InvalidGridSizeException exception = assertThrows(InvalidGridSizeException.class, () -> {
            new GameConfig(0, 2);  // Zero grid size
        });
        // Update the expected message based on actual validation logic
        assertEquals("Grid size must be between 2 and 20", exception.getMessage());
    }

    @Test
    void testNullMineCount() {
        InvalidMineCountException exception = assertThrows(InvalidMineCountException.class, () -> {
            new GameConfig(4, null);  // Null mine count
        });
        assertEquals("Mine count must not be null.", exception.getMessage());
    }
    @Test
    void testZeroMineCount() {
        InvalidMineCountException exception = assertThrows(InvalidMineCountException.class, () -> {
            new GameConfig(4, 0);  // Zero mine count
        });

        // Calculate the maximum allowed mine count for a 4x4 grid
        int maxMines = (int) (4 * 4 * MINE_PERCENTAGE); // Assuming MINE_PERCENTAGE is set correctly
        assertEquals("Mine count must be greater than zero and no more than " + maxMines + " for the given grid size.", exception.getMessage());
    }
}


