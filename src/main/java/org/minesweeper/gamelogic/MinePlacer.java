package org.minesweeper.gamelogic;

import org.minesweeper.core.Grid;

import java.util.Random;

public class MinePlacer {

    private final Grid grid;

    public MinePlacer(Grid grid) {
        this.grid = grid;
    }

    // Places mines randomly on the grid until the specified mine count is reached
    public void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;

        // Continue placing mines until the required number is reached
        while (minesPlaced < grid.getMineCount()) {
            int row = random.nextInt(grid.getSize());
            int col = random.nextInt(grid.getSize());
            // Check if the selected cell already has a mine
            if (!grid.getCell(row, col).isMine()) {
                grid.getCell(row, col).placeMine();
                minesPlaced++;
                updateAdjacentMines(row, col);
            }
        }
    }

    // Updates the adjacent cells' mine counts for the newly placed mine
    private void updateAdjacentMines(int mineRow, int mineCol) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = mineRow + i;
                int newCol = mineCol + j;

                if (isValidCell(newRow, newCol) && !grid.getCell(newRow, newCol).isMine()) {
                    grid.getCell(newRow, newCol).incrementAdjacentMines();
                }
            }
        }
    }

    // Checks if the specified cell (row, col) is valid within the grid boundaries
    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < grid.getSize() && col >= 0 && col < grid.getSize();
    }
}


