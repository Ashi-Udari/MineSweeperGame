package org.minesweeper.config;

import org.minesweeper.exception.InvalidGridSizeException;
import org.minesweeper.exception.InvalidLanguageException;
import org.minesweeper.exception.InvalidMineCountException;

import java.util.Scanner;

public class GameInitializer {

    public LanguageManager initializeLanguage(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Select language (en/fr): ");
                String langCode = scanner.nextLine().trim();
                return new LanguageManager(langCode);
            } catch (InvalidLanguageException e) {
                System.out.println("Invalid language selection. Try again.");
            }
        }
    }

    public GameConfig initializeGameConfig(Scanner scanner, LanguageManager langManager) {
        while (true) {
            try {
                System.out.println(langManager.getMessage("game.grid.size.prompt"));
                int gridSize = Integer.parseInt(scanner.nextLine().trim());
                System.out.println(langManager.getMessage("game.mine.count.prompt"));
                int mineCount = Integer.parseInt(scanner.nextLine().trim());
                return new GameConfig(gridSize, mineCount);
            } catch (InvalidGridSizeException | InvalidMineCountException | NumberFormatException e) {
                System.out.println(langManager.getMessage("game.invalid.input") + e.getMessage());
            }
        }
    }
}
