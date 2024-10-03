package org.minesweeper.controller;

import org.minesweeper.config.GameConfig;
import org.minesweeper.config.LanguageManager;
import org.minesweeper.exception.InvalidGridSizeException;
import org.minesweeper.exception.InvalidLanguageException;
import org.minesweeper.exception.InvalidMineCountException;

import java.util.Scanner;

public class GameRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Handle language selection
            System.out.println("Select language (en for English, fr for French): ");
            String languageCode = scanner.nextLine().trim();
            LanguageManager languageManager = new LanguageManager(languageCode);

            // Handle grid size and mine count input
            System.out.println(languageManager.getMessage("game.grid.prompt"));
            int gridSize = scanner.nextInt();

            System.out.println(languageManager.getMessage("game.mines.prompt"));
            int mineCount = scanner.nextInt();

            try {
                GameConfig config = new GameConfig(gridSize, mineCount);
                MineSweeperGame game = new MineSweeperGame(config, languageManager);
                game.startGame();
            } catch (InvalidGridSizeException | InvalidMineCountException e) {
                System.out.println(e.getMessage());
            }

        } catch (InvalidLanguageException e) {
            System.out.println(e.getMessage());
        }
    }

}
