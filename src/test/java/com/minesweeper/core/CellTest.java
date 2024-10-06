package com.minesweeper.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.core.Cell;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    private Cell cell;

    @BeforeEach
    void setUp() {
        cell = new Cell();  // Create a new cell before each test
    }

    @Test
    void testDefaultCellState() {
        // Check default state of a new cell
        assertFalse(cell.isMine(), "Default cell should not be a mine");
        assertFalse(cell.isRevealed(), "Default cell should not be revealed");
        assertEquals(0, cell.getAdjacentMines(), "Default adjacent mines count should be 0");
    }

    @Test
    void testPlaceMine() {
        // Test placing a mine on the cell
        cell.placeMine();
        assertTrue(cell.isMine(), "Cell should be a mine after calling placeMine()");
    }

    @Test
    void testRevealCell() {
        // Test revealing a cell
        cell.reveal();
        assertTrue(cell.isRevealed(), "Cell should be revealed after calling reveal()");
    }

    @Test
    void testIncrementAdjacentMines() {
        // Test incrementing the adjacent mines count
        cell.incrementAdjacentMines();
        assertEquals(1, cell.getAdjacentMines(), "Adjacent mine count should increment to 1");

        cell.incrementAdjacentMines();
        assertEquals(2, cell.getAdjacentMines(), "Adjacent mine count should increment to 2");
    }

    @Test
    void testRevealMine() {
        // Test revealing a mine
        cell.placeMine();
        cell.reveal();
        assertTrue(cell.isRevealed(), "Mine cell should be revealed");
        assertTrue(cell.isMine(), "Revealed cell should be a mine");
    }
}
