package org.minesweeper.core;

import java.util.Random;

public class Grid {

    private final Cell[][] grid;  // 2D array for storing cells
    private final Integer size;       // Grid size
    private final Integer mineCount;  // Number of mines

    public Grid(int size, int mineCount) {
        this.size = size;
        this.mineCount = mineCount;
        this.grid = new Cell[size][size];

        // Initialize the grid with Cell objects
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = new Cell();
            }
        }
    }

    public Cell getCell(int row, int col) {
        return grid[row][col];
    }

    public int getSize() {
        return size;
    }

    public int getMineCount() {
        return mineCount;
    }


}
