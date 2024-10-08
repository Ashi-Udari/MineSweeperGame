package org.minesweeper.config;

import org.minesweeper.exception.InvalidGridSizeException;
import org.minesweeper.exception.InvalidMineCountException;
import org.minesweeper.util.GameValidation;

public class GameConfig {

    private final Integer gridSize;
    private final Integer mineCount;

    public GameConfig(Integer gridSize, Integer mineCount) throws InvalidGridSizeException, InvalidMineCountException {
        GameValidation.validateGridSize(gridSize);
        GameValidation.validateMineCount(gridSize, mineCount);
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


