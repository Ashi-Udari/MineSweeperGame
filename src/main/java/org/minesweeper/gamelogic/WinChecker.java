package org.minesweeper.gamelogic;

import org.minesweeper.core.Cell;
import org.minesweeper.core.Grid;



public class WinChecker {

    private final Grid grid;

    public WinChecker(Grid grid) {
        this.grid = grid;
    }

    public boolean isGameWon() {
        for (int row = 0; row < grid.getSize(); row++) {
            for (int col = 0; col < grid.getSize(); col++) {
                Cell cell = grid.getCell(row, col);
                if (!cell.isMine() && !cell.isRevealed()) {
                    return false;  // If any non-mine cell is not revealed, the game is not won
                }
            }
        }
        return true;  // All non-mine cells are revealed
    }
}


