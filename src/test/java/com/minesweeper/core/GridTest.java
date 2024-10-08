package com.minesweeper.core;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.core.Cell;
import org.minesweeper.core.Grid;

import static org.junit.jupiter.api.Assertions.*;



class GridTest {

    private Grid grid;

    @BeforeEach
    void setUp() {
        grid = new Grid(4, 2);  // Create a 4x4 grid with 2 mines
    }

    @Test
    void testGridInitialization() {
        assertEquals(4, grid.getSize(), "Grid size should be 4x4.");
        assertEquals(2, grid.getMineCount(), "There should be 2 mines on the grid.");
    }

    @Test
    void testGetCell() {
        Cell cell = grid.getCell(0, 0);
        assertNotNull(cell, "Cell should not be null.");
    }
}
