package com.minesweeper.config;

import org.junit.jupiter.api.Test;
import org.minesweeper.config.GameConfig;
import org.minesweeper.exception.InvalidGridSizeException;
import org.minesweeper.exception.InvalidMineCountException;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals("Grid size must be greater than zero and not null.", exception.getMessage());
    }

    @Test
    void testZeroGridSize() {
        InvalidGridSizeException exception = assertThrows(InvalidGridSizeException.class, () -> {
            new GameConfig(0, 2);  // Zero grid size
        });
        assertEquals("Grid size must be greater than zero and not null.", exception.getMessage());
    }

    @Test
    void testNullMineCount() {
        InvalidMineCountException exception = assertThrows(InvalidMineCountException.class, () -> {
            new GameConfig(4, null);  // Null mine count
        });
        assertEquals("Mine count must be positive, not null, and no more than 35% of the grid size.", exception.getMessage());
    }

    @Test
    void testZeroMineCount() {
        InvalidMineCountException exception = assertThrows(InvalidMineCountException.class, () -> {
            new GameConfig(4, 0);  // Zero mine count
        });
        assertEquals("Mine count must be positive, not null, and no more than 35% of the grid size.", exception.getMessage());
    }


}
