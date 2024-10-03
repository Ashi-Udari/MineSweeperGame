package org.minesweeper.config;

import org.minesweeper.exception.InvalidGridSizeException;
import org.minesweeper.exception.InvalidMineCountException;

public class GameConfig {

    private final int gridSize;
    private final int mineCount;

    public GameConfig(int gridSize, int mineCount) throws InvalidGridSizeException, InvalidMineCountException {
        if (gridSize <= 0) {
            throw new InvalidGridSizeException("Grid size must be greater than zero.");
        }
        if (mineCount <= 0 || mineCount > gridSize * gridSize * 0.35) {
            throw new InvalidMineCountException("Mine count must be positive and no more than 35% of the grid size.");
        }
        this.gridSize = gridSize;
        this.mineCount = mineCount;
    }

    public int getGridSize() {
        return gridSize;
    }

    public int getMineCount() {
        return mineCount;
    }

}
