package org.minesweeper.ui;

import org.minesweeper.exception.InvalidCellSelectionException;

public class InputParser {

    // Private constructor to prevent instantiation
    private InputParser() {
        throw new UnsupportedOperationException("Utility class");
    }

    // Parses the user's cell selection input and converts it into grid indices
    public static int[] parseCellSelection(String input, int gridSize) throws InvalidCellSelectionException {
        int row = getRow(input, gridSize);
        int col;
        try {
            // Subtract 1 to convert to zero-based index
            col = Integer.parseInt(input.substring(1)) - 1;
        } catch (NumberFormatException e) {
            throw new InvalidCellSelectionException("Invalid column selection. Please select a valid column.");
        }

        if (col < 0 || col >= gridSize) {
            throw new InvalidCellSelectionException("Invalid column selection. Please select a column within the grid.");
        }

        return new int[]{row, col};
    }

    private static int getRow(String input, int gridSize) throws InvalidCellSelectionException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidCellSelectionException("Invalid input format. Please enter a valid cell (e.g., A1).");
        }

        if (input.length() < 2) {
            throw new InvalidCellSelectionException("Input too short. Please enter a valid cell (e.g., A1).");
        }

        // Extract row and column from input
        char rowChar = input.charAt(0);
        if (rowChar < 'A' || rowChar >= ('A' + gridSize)) {
            throw new InvalidCellSelectionException("Invalid row selection. Please select a valid row.");
        }

        return rowChar - 'A';
    }

}
