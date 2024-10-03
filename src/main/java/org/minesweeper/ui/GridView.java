package org.minesweeper.ui;

import org.minesweeper.config.LanguageManager;
import org.minesweeper.core.Grid;

public class GridView {

    private final LanguageManager languageManager;

    public GridView(LanguageManager languageManager) {
        this.languageManager = languageManager;
    }

    public void displayGrid(Grid grid) {
        int size = grid.getSize();
        System.out.print("  ");
        for (int i = 1; i <= size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int row = 0; row < size; row++) {
            char rowLabel = (char) ('A' + row);
            System.out.print(rowLabel + " ");
            for (int col = 0; col < size; col++) {
                if (grid.getCell(row, col).isRevealed()) {
                    if (grid.getCell(row, col).isMine()) {
                        System.out.print("* ");
                    } else {
                        System.out.print(grid.getCell(row, col).getAdjacentMines() + " ");
                    }
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }

}
