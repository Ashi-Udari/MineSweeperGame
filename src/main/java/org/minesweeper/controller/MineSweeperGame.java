package org.minesweeper.controller;

import org.minesweeper.config.GameConfig;
import org.minesweeper.config.LanguageManager;
import org.minesweeper.core.Grid;
import org.minesweeper.exception.InvalidCellSelectionException;
import org.minesweeper.ui.GridView;
import org.minesweeper.ui.InputParser;

import java.util.Scanner;

public class MineSweeperGame {

    private final Grid grid;
    private final GridView gridView;
    private final LanguageManager languageManager;

    public MineSweeperGame(GameConfig config, LanguageManager languageManager) {
        this.grid = new Grid(config.getGridSize(), config.getMineCount());
        this.gridView = new GridView(languageManager);
        this.languageManager = languageManager;
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(languageManager.getMessage("game.welcome"));

        while (true) {
            gridView.displayGrid(grid);
            System.out.println(languageManager.getMessage("game.select.prompt"));
            String input = scanner.nextLine();

            try {
                int[] cell = InputParser.parseCellSelection(input, grid.getSize());
                int row = cell[0];
                int col = cell[1];

                boolean safe = grid.revealCell(row, col);
                if (!safe) {
                    System.out.println(languageManager.getMessage("game.mine.hit"));
                    break;
                }

                if (checkWinCondition()) {
                    System.out.println(languageManager.getMessage("game.congratulations"));
                    break;
                }
            } catch (InvalidCellSelectionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private boolean checkWinCondition() {
        // Logic for determining if the player has won the game
        return false;
    }

}
