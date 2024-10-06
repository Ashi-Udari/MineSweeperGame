package com.minesweeper.gamelogic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.core.Grid;
import org.minesweeper.gamelogic.CellRevealer;

import static org.junit.jupiter.api.Assertions.*;


class CellRevealerTest {

    private Grid grid;
    private CellRevealer cellRevealer;

    @BeforeEach
    void setUp() {
        grid = new Grid(4, 2);  // 4x4 grid with 2 mines
        cellRevealer = new CellRevealer(grid);
    }

    @Test
    void testRevealNonMineCell() {
        assertTrue(cellRevealer.revealCell(0, 0), "Revealing a non-mine cell should return true.");
        assertTrue(grid.getCell(0, 0).isRevealed(), "Cell should be marked as revealed.");
    }

    @Test
    void testRevealMineCell() {
        // Place a mine manually for this test
        grid.getCell(0, 0).placeMine();
        assertFalse(cellRevealer.revealCell(0, 0), "Revealing a mine should return false (game over).");
    }

    @Test
    void testRecursiveReveal() {
        // Ensure no mines around 1, 1 so it reveals surrounding cells
        grid.getCell(0, 0).placeMine();  // Place a mine in 0,0, rest are safe
        assertTrue(cellRevealer.revealCell(1, 1), "Revealing a non-mine cell should return true.");
        assertTrue(grid.getCell(1, 1).isRevealed(), "Center cell should be revealed.");
        assertTrue(grid.getCell(2, 2).isRevealed(), "Nearby empty cell should also be revealed.");
    }
}



//public class CellRevealerTest {
//
//    private Grid grid;
//    private CellRevealer revealer;
//
//    @BeforeEach
//    void setUp() {
//        grid = new Grid(4, 2);
//        revealer = new CellRevealer(grid);
//    }
//
//    @Test
//    void testRevealNonMineCell() {
//        assertTrue(revealer.revealCell(0, 0), "Revealing a non-mine cell should return true.");
//    }
//
//    @Test
//    void testRevealMineCell() {
//        grid.getCell(0, 0).placeMine();  // Place a mine
//        assertFalse(revealer.revealCell(0, 0), "Revealing a mine should return false (game over).");
//    }
//
//
//}
