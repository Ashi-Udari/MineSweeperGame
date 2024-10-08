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







//public class GameConfig {
//
//    //Configuration class for game grid size and mines validation
//
//    private final Integer gridSize;
//    private final Integer mineCount;
//
//    public GameConfig(Integer gridSize, Integer mineCount) throws InvalidGridSizeException, InvalidMineCountException {
//        validateGridSize(gridSize);
//        validateMineCount(gridSize, mineCount);
//        this.gridSize = gridSize;
//        this.mineCount = mineCount;
//    }
//
//    private void validateGridSize(Integer gridSize) throws InvalidGridSizeException {
//        if (gridSize == null || gridSize <= 0) {
//            throw new InvalidGridSizeException("Grid size must be greater than zero and not null.");
//        }
//    }
//
//    private void validateMineCount(Integer gridSize, Integer mineCount) throws InvalidMineCountException {
//        if (mineCount == null || mineCount <= 0 || mineCount > gridSize * gridSize * 0.35) {
//            throw new InvalidMineCountException("Mine count must be positive, not null, and no more than 35% of the grid size.");
//        }
//    }
//
//    public int getGridSize() {
//        return gridSize;
//    }
//
//    public int getMineCount() {
//        return mineCount;
//    }
//}




