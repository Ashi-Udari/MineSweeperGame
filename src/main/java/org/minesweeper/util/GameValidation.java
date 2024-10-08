package org.minesweeper.util;

import org.minesweeper.exception.InvalidGridSizeException;
import org.minesweeper.exception.InvalidMineCountException;

import java.util.ResourceBundle;

public class GameValidation {

    private static final ResourceBundle config = ResourceBundle.getBundle("gameconfig");

    private static final int MIN_GRID_SIZE = Integer.parseInt(config.getString("game.grid.size.min"));
    private static final int MAX_GRID_SIZE = Integer.parseInt(config.getString("game.grid.size.max"));
    private static final double MINE_PERCENTAGE = Double.parseDouble(config.getString("game.mine.percentage"));

    public static void validateGridSize(int gridSize) throws InvalidGridSizeException {
        if (gridSize < MIN_GRID_SIZE || gridSize > MAX_GRID_SIZE) {
            throw new InvalidGridSizeException("Grid size must be between " + MIN_GRID_SIZE + " and " + MAX_GRID_SIZE);
        }
    }

    public static void validateMineCount(int gridSize, int mineCount) throws InvalidMineCountException {
        int maxMines = (int) (gridSize * gridSize * MINE_PERCENTAGE);
        if (mineCount <= 0 || mineCount > maxMines) {
            throw new InvalidMineCountException("Mine count must be greater than zero and no more than " + maxMines + " for the given grid size.");
        }
    }

}
