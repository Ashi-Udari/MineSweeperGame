package org.minesweeper.core;

import java.util.Random;

public class Grid {

    private Cell[][] grid;
    private int size;

    public Grid(int size, int mineCount) {
        this.size = size;
        this.grid = new Cell[size][size];
        initializeGrid();
        placeMines(mineCount);
        calculateAdjacentMines();
    }

    private void initializeGrid() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    private void placeMines(int mineCount) {
        Random rand = new Random();
        int minesPlaced = 0;

        while (minesPlaced < mineCount) {
            int row = rand.nextInt(size);
            int col = rand.nextInt(size);

            if (!grid[row][col].isMine()) {
                grid[row][col].placeMine();
                minesPlaced++;
            }
        }
    }

    private void calculateAdjacentMines() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col].isMine()) continue;
                // Count adjacent mines.
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (isValidCell(row + i, col + j) && grid[row + i][col + j].isMine()) {
                            grid[row][col].incrementAdjacentMines();
                        }
                    }
                }
            }
        }
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public boolean revealCell(int row, int col) {
        if (grid[row][col].isMine()) {
            return false;  // Game over condition.
        }
        grid[row][col].reveal();
        return true;
    }

    public int getSize() {
        return size;
    }


}
