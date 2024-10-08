package org.minesweeper.config;

import org.minesweeper.exception.InvalidGridSizeException;
import org.minesweeper.exception.InvalidLanguageException;
import org.minesweeper.exception.InvalidMineCountException;

import java.util.Scanner;

public class GameInitializer {

    //Initializes the game setup, including the grid and mine placement.

    public LanguageManager initializeLanguage(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Please Select language to begin (en/fr): Press Enter to continue with English ");
                String langCode = scanner.nextLine().trim();

                // Ensure valid language selection
                if (langCode.equals("en") || langCode.equals("fr")) {
                    return new LanguageManager(langCode);  // Pass language code to LanguageManager
                } else {
                    //set the default language to English
                    return new LanguageManager("en");
                   //System.out.println("Invalid language code. Please select either 'en' for English or 'fr' for French.");
                }
            } catch (InvalidLanguageException e) {
                System.out.println("Error initializing language. " + e.getMessage());
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
