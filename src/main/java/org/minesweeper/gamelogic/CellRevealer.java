package org.minesweeper.gamelogic;

import org.minesweeper.core.Cell;
import org.minesweeper.core.Grid;


public class CellRevealer {

    private final Grid grid;

    public CellRevealer(Grid grid) {
        this.grid = grid;
    }

    public boolean revealCell(int row, int col) {
        Cell cell = grid.getCell(row, col);
        if (cell.isRevealed()) {
            return true;  // Already revealed
        }

        cell.reveal();
        if (cell.isMine()) {
            return false;  // Game over if the cell is a mine
        }

        if (cell.getAdjacentMines() == 0) {
            revealSurroundingCells(row, col);  // Recursively reveal surrounding cells if there are no adjacent mines
        }
        return true;
    }

    private void revealSurroundingCells(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (isValidCell(newRow, newCol)) {
                    revealCell(newRow, newCol);
                }
            }
        }
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < grid.getSize() && col >= 0 && col < grid.getSize();
    }

    public boolean isValidSelection(int row, int col) {
        return row >= 0 && row < grid.getSize() && col >= 0 && col < grid.getSize();
    }
}



