package org.minesweeper.gamelogic;

import org.minesweeper.core.Grid;

import java.util.Random;

public class MinePlacer {

    private final Grid grid;

    public MinePlacer(Grid grid) {
        this.grid = grid;
    }

    public void placeMines() {
        Random random = new Random();
        int minesPlaced = 0;

        while (minesPlaced < grid.getMineCount()) {
            int row = random.nextInt(grid.getSize());
            int col = random.nextInt(grid.getSize());

            if (!grid.getCell(row, col).isMine()) {
                grid.getCell(row, col).placeMine();
                minesPlaced++;
                updateAdjacentMines(row, col);
            }
        }
    }

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

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < grid.getSize() && col >= 0 && col < grid.getSize();
    }
}





//public class MinePlacer {
//
//    private final Grid grid;
//
//    public MinePlacer(Grid grid) {
//        this.grid = grid;
//    }
//
//    // Place mines randomly on the grid
//    public void placeMines() {
//        Random random = new Random();
//        int minesPlaced = 0;
//
//        while (minesPlaced < grid.getMineCount()) {
//            int row = random.nextInt(grid.getSize());
//            int col = random.nextInt(grid.getSize());
//
//            if (!grid.getCell(row, col).isMine()) {
//                grid.getCell(row, col).placeMine();
//                minesPlaced++;
//                updateAdjacentMines(row, col);
//            }
//        }
//    }
//
//    // Update adjacent mine counts for neighboring cells
//    private void updateAdjacentMines(int mineRow, int mineCol) {
//        for (int i = -1; i <= 1; i++) {
//            for (int j = -1; j <= 1; j++) {
//                int newRow = mineRow + i;
//                int newCol = mineCol + j;
//
//                if (isValidCell(newRow, newCol) && !grid.getCell(newRow, newCol).isMine()) {
//                    grid.getCell(newRow, newCol).incrementAdjacentMines();
//                }
//            }
//        }
//    }
//
//    // Check if the cell coordinates are valid
//    private boolean isValidCell(int row, int col) {
//        return row >= 0 && row < grid.getSize() && col >= 0 && col < grid.getSize();
//    }
//
//
//}
