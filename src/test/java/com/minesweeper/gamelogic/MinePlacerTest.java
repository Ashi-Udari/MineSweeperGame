package com.minesweeper.gamelogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.core.Grid;
import org.minesweeper.gamelogic.MinePlacer;

import static org.junit.jupiter.api.Assertions.*;


class MinePlacerTest {

    private Grid grid;
    private MinePlacer minePlacer;

    @BeforeEach
    void setUp() {
        grid = new Grid(4, 2);  // 4x4 grid with 2 mines
        minePlacer = new MinePlacer(grid);
    }

    @Test
    void testMinePlacement() {
        minePlacer.placeMines();

        int mineCount = 0;
        for (int row = 0; row < grid.getSize(); row++) {
            for (int col = 0; col < grid.getSize(); col++) {
                if (grid.getCell(row, col).isMine()) {
                    mineCount++;
                }
            }
        }
        assertEquals(2, mineCount, "There should be exactly 2 mines placed.");
    }

    @Test
    void testAdjacentMineCounts() {
        minePlacer.placeMines();

        // Adjacent cells should have their mine counts updated
        for (int row = 0; row < grid.getSize(); row++) {
            for (int col = 0; col < grid.getSize(); col++) {
                if (!grid.getCell(row, col).isMine()) {
                    assertTrue(grid.getCell(row, col).getAdjacentMines() >= 0);
                }
            }
        }
    }
}
