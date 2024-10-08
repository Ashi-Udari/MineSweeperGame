package org.minesweeper.util;

import org.minesweeper.exception.InvalidGridSizeException;
import org.minesweeper.exception.InvalidMineCountException;

import java.util.ResourceBundle;

public class GameValidation {

    private static final ResourceBundle config = ResourceBundle.getBundle("gameconfig");

    private static final int MIN_GRID_SIZE = Integer.parseInt(config.getString("game.grid.size.min"));
    private static final int MAX_GRID_SIZE = Integer.parseInt(config.getString("game.grid.size.max"));
    public static final double MINE_PERCENTAGE = Double.parseDouble(config.getString("game.mine.percentage"));

    // Validate the grid size against the defined minimum and maximum limits
    public static void validateGridSize(Integer gridSize) throws InvalidGridSizeException {
        if (gridSize == null) {
            throw new InvalidGridSizeException("Grid size must not be null.");
        }
        if (gridSize < MIN_GRID_SIZE || gridSize > MAX_GRID_SIZE) {
            throw new InvalidGridSizeException("Grid size must be between " + MIN_GRID_SIZE + " and " + MAX_GRID_SIZE);
        }
    }

    // Validate the number of mines against the grid size and mine percentage
    public static void validateMineCount(Integer gridSize, Integer mineCount) throws InvalidMineCountException {
        // Calculate the maximum number of mines allowed based on grid size and mine percentage
        int maxMines = (int) (gridSize * gridSize * MINE_PERCENTAGE);

        if (mineCount == null) {
            throw new InvalidMineCountException("Mine count must not be null.");
        }

        if (mineCount <= 0 || mineCount > maxMines) {
            throw new InvalidMineCountException("Mine count must be greater than zero and no more than " + maxMines + " for the given grid size.");
        }
    }

}
