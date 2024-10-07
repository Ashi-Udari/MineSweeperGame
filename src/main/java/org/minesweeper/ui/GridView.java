package org.minesweeper.ui;
import org.minesweeper.core.Grid;
import org.minesweeper.core.Cell;

public class GridView {

    private final Grid grid;

    public GridView(Grid grid) {
        this.grid = grid;
    }

    // Print the grid to the console, optionally revealing mines
    public void printGrid(boolean showMines) {
        // Column headers
        System.out.print("  ");
        for (int row = 0; row < grid.getSize(); row++) {
            System.out.print( (row+1)+ " ");
        }
        System.out.println();
        // Iterate over the grid
        for (int row = 0; row < grid.getSize(); row++) {
            char rowLabel = (char) ('A' + row);  // Row labels: A, B, C, etc.
            System.out.print(rowLabel + " ");
            for (int col = 0; col < grid.getSize(); col++) {
                Cell cell = grid.getCell(row, col);

                // Display logic based on whether the cell is revealed or not
                if (!cell.isRevealed()) {
                    if (showMines && cell.isMine()) {
                        System.out.print("* ");  // Show mines at the end of the game
                    } else {
                        System.out.print("_ ");  // Hidden cells
                    }
                } else if (cell.isMine()) {
                    System.out.print("* ");  // If the game is over, show mines
                } else {
                    System.out.print(cell.getAdjacentMines() + " ");  // Show adjacent mine count
                }
            }
            System.out.println();  // Newline after each row
        }
    }
}

