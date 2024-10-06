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

//class GridTest {
//
//    private Grid grid;
//
//    @BeforeEach
//    void setUp() {
//        grid = new Grid(4, 2);  // Create a 4x4 grid with 2 mines
//    }
//
//    @Test
//    void testGridInitialization() {
//        // Check grid size
//        assertEquals(4, grid.getSize(), "Grid size should be 4x4");
//    }
//
//    @Test
//    void testMinePlacement() {
//        // Check mine placement
//        int mineCount = 0;
//        for (int row = 0; row < 4; row++) {
//            for (int col = 0; col < 4; col++) {
//                if (grid.getCell(row, col).isMine()) {
//                    mineCount++;
//                }
//            }
//        }
//        assertEquals(2, mineCount, "There should be exactly 2 mines placed on the grid");
//    }
//
//    @Test
//    void testRevealSafeCell() {
//        // Test revealing a safe (non-mine) cell
//        for (int row = 0; row < 4; row++) {
//            for (int col = 0; col < 4; col++) {
//                if (!grid.getCell(row, col).isMine()) {
//                    assertTrue(grid.revealCell(row, col), "Revealing a non-mine cell should return true");
//                    assertTrue(grid.getCell(row, col).isRevealed(), "Cell should be revealed");
//                    break;
//                }
//            }
//        }
//    }
//
//    @Test
//    void testRevealMineCell() {
//        // Test revealing a mine cell
//        for (int row = 0; row < 4; row++) {
//            for (int col = 0; col < 4; col++) {
//                if (grid.getCell(row, col).isMine()) {
//                    assertFalse(grid.revealCell(row, col), "Revealing a mine cell should return false");
//                    break;
//                }
//            }
//        }
//    }
//
//    @Test
//    void testAdjacentMinesCalculation() {
//        // Test adjacent mine calculation
//        grid.getCell(1, 1).placeMine();  // Place a mine at B2
//        grid.getCell(2, 2).placeMine();  // Place a mine at C3
//
//        // Verify the adjacent mine counts
//        assertEquals(2, grid.getCell(1, 2).getAdjacentMines(), "Cell B3 should have 2 adjacent mines");
//        assertEquals(1, grid.getCell(0, 1).getAdjacentMines(), "Cell A2 should have 1 adjacent mine");
//        assertEquals(1, grid.getCell(2, 1).getAdjacentMines(), "Cell C2 should have 1 adjacent mine");
//        assertEquals(2, grid.getCell(2, 3).getAdjacentMines(), "Cell C4 should have 2 adjacent mines");
//    }
//
//    @Test
//    void testRevealZeroAdjacentMines() {
//        // Test revealing a cell with 0 adjacent mines
//        grid.getCell(0, 0).reveal();  // Assume A1 has 0 adjacent mines
//        for (int row = 0; row < 4; row++) {
//            for (int col = 0; col < 4; col++) {
//                Cell cell = grid.getCell(row, col);
//                if (!cell.isMine() && cell.getAdjacentMines() == 0) {
//                    assertTrue(cell.isRevealed(), "Cells with 0 adjacent mines should be revealed");
//                }
//            }
//        }
//    }
//}
