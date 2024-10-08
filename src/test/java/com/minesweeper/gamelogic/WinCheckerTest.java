package com.minesweeper.gamelogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.core.Grid;
import org.minesweeper.gamelogic.WinChecker;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class WinCheckerTest {

    private Grid grid;
    private WinChecker winChecker;

    @BeforeEach
    void setUp() {
        grid = new Grid(4, 2);  // 4x4 grid with 2 mines
        winChecker = new WinChecker(grid);
    }

    @Test
    void testWinCondition() {
        // Reveal all non-mine cells manually for the win condition
        for (int row = 0; row < grid.getSize(); row++) {
            for (int col = 0; col < grid.getSize(); col++) {
                if (!grid.getCell(row, col).isMine()) {
                    grid.getCell(row, col).reveal();
                }
            }
        }
        assertTrue(winChecker.isGameWon(), "The game should be won when all non-mine cells are revealed.");
    }

    @Test
    void testNotWonCondition() {
        // Do not reveal any cells, so the game is not won yet
        assertFalse(winChecker.isGameWon(), "The game should not be won if there are unrevealed non-mine cells.");
    }
}
