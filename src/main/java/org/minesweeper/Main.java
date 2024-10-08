package org.minesweeper;

import org.minesweeper.config.GameConfig;
import org.minesweeper.config.GameInitializer;
import org.minesweeper.config.LanguageManager;
import org.minesweeper.controller.MineSweeperGame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().startGame();  // Start the game initially
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        GameInitializer initializer = new GameInitializer();  // Initialize the GameInitializer

        while (true) {
            // Reinitialize language and game configuration for every new game
            LanguageManager langManager = initializer.initializeLanguage(scanner);
            GameConfig gameConfig = initializer.initializeGameConfig(scanner, langManager);

            // Create a new game instance with fresh settings and start the game
            MineSweeperGame game = new MineSweeperGame(gameConfig, langManager);
            game.start();

            // Prompt the user for replay after the game ends
            if (!game.promptReplay(scanner)) {
                break;  // Exit the game loop if the player doesn't want to replay
            }
        }
        scanner.close();  // Close the scanner when finished
    }
}
