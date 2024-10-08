package org.minesweeper.gamelogic;

import org.minesweeper.core.Cell;
import org.minesweeper.core.Grid;

public class WinChecker {

    private final Grid grid;

    public WinChecker(Grid grid) {
        this.grid = grid;
    }

    // Checks if the game is won by verifying if all non-mine cells are revealed
    public boolean isGameWon() {
        // Loop through each cell in the grid
        for (int row = 0; row < grid.getSize(); row++) {
            for (int col = 0; col < grid.getSize(); col++) {
                Cell cell = grid.getCell(row, col);
                // Check if there is a non-mine cell that is not revealed
                if (!cell.isMine() && !cell.isRevealed()) {
                    return false;  // If any non-mine cell is not revealed, the game is not won
                }
            }
        }
        return true;  // All non-mine cells are revealed
    }
}


