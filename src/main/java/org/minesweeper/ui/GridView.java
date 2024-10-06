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
        System.out.println("  1 2 3 4");  // Column headers

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


//public class GridView {
//
//    private final LanguageManager languageManager;
//
//    public GridView(LanguageManager languageManager) {
//        this.languageManager = languageManager;
//    }
//
//    public void displayGrid(Grid grid) {
//        int size = grid.getSize();
//        System.out.print("  ");
//        for (int i = 1; i <= size; i++) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//
//        for (int row = 0; row < size; row++) {
//            char rowLabel = (char) ('A' + row);
//            System.out.print(rowLabel + " ");
//            for (int col = 0; col < size; col++) {
//                if (grid.getCell(row, col).isRevealed()) {
//                    if (grid.getCell(row, col).isMine()) {
//                        System.out.print("* ");
//                    } else {
//                        System.out.print(grid.getCell(row, col).getAdjacentMines() + " ");
//                    }
//                } else {
//                    System.out.print("_ ");
//                }
//            }
//            System.out.println();
//        }
//    }
//
//}
