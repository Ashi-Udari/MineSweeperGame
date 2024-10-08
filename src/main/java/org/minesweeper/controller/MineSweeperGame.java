
package org.minesweeper.controller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.minesweeper.Main;
import org.minesweeper.config.GameConfig;
import org.minesweeper.config.LanguageManager;
import org.minesweeper.core.Grid;
import org.minesweeper.exception.InvalidInputException;
import org.minesweeper.gamelogic.CellRevealer;
import org.minesweeper.gamelogic.MinePlacer;
import org.minesweeper.gamelogic.WinChecker;
import org.minesweeper.ui.GridView;

import java.util.Scanner;

public class  MineSweeperGame {

    // Logger for logging game events
    private static final Logger logger = LogManager.getLogger(MineSweeperGame.class);

    // Language manager for localized messages
    private final LanguageManager langManager;
    private GameConfig config;
    private boolean gameOver;

    // Game components
    private Grid grid;
    private MinePlacer minePlacer;
    private CellRevealer cellRevealer;
    private WinChecker winChecker;
    private GridView gridView;

    // Constructor initializes game with provided config and language manager
    public MineSweeperGame(GameConfig config, LanguageManager langManager) {
        this.langManager = langManager;
        this.config = config;
        resetGame(); // Initialize game components
    }


    // Resets the game state and initializes game components
    private void resetGame() {
        logger.info("Game is being reset with grid size: {} and mine count: {}", config.getGridSize(), config.getMineCount());

        this.grid = new Grid(config.getGridSize(), config.getMineCount());
        this.minePlacer = new MinePlacer(grid);
        this.cellRevealer = new CellRevealer(grid);
        this.winChecker = new WinChecker(grid);
        this.gridView = new GridView(grid);
        this.gameOver = false;

        minePlacer.placeMines();  // Place mines when the game starts
        logger.info("Mines successfully placed on the grid.");
    }

    // Starts the Minesweeper game
    public void start() {
            logger.info("Starting the Minesweeper game.");
            Scanner scanner = new Scanner(System.in);
            System.out.println(langManager.getMessage("game.welcome"));

            // Print the initial grid (all hidden)
            gridView.printGrid(false);

        // Game loop
            while (!gameOver) {
                try {
                    // Prompt user to select a cell
                    System.out.println(langManager.getMessage("game.select.cell"));
                    String input = scanner.nextLine().trim();
                    if (input.isEmpty()) {
                        logger.warn("Empty input received from user.");
                        throw new InvalidInputException(langManager.getMessage("game.input.error"));
                    }


                    // Convert input (e.g., "A1") to grid indices
                    int[] indices = parseInput(input);
                    int row = indices[0];
                    int col = indices[1];

                    logger.debug("User selected cell at row: {}, column: {}", row, col);

                    // Reveal the selected cell and check for game over
                    if (!cellRevealer.revealCell(row, col)) {
                        logger.info("User hit a mine at ({}, {}). Game over.", row, col);
                        System.out.println(langManager.getMessage("game.hit.mine"));
                        gameOver = true;
                        gridView.printGrid(true);  // Show all cells including mines
                    } else if (winChecker.isGameWon()) {
                        logger.info("User has won the game.");
                        System.out.println(langManager.getMessage("game.win"));
                        gameOver = true;
                        gridView.printGrid(true);  // Show the final grid with all revealed cells
                    } else {
                        logger.debug("User revealed a cell without hitting a mine. Current game state continues.");
                        // Print the updated grid with revealed cells
                        gridView.printGrid(false);
                    }
                } catch (InvalidInputException e) {
                    logger.error("Invalid input: {}", e.getMessage());
                    System.out.println(e.getMessage());
                }

                // After the game ends, ask the user to replay
                if (gameOver) {
                    if (promptReplay(scanner)) {
                        //resetGame();  // Reset the game for replay
                        //start();// Restart the game
                        new Main().startGame();

                    }
                    else{
                        logger.info("Game ended by user.");
                        break;
                    }
                }
            }
        }

        // Converts user input (like "A1") into row and column indices
        private int[] parseInput(String input) throws InvalidInputException {
            try {
                char rowChar = input.charAt(0);
                int col = Integer.parseInt(input.substring(1)) - 1;

                if (rowChar < 'A' || rowChar > 'Z' || col < 0 || col >= grid.getSize()) {
                    logger.warn("Invalid cell selection: {}. Out of range.", input);
                    throw new InvalidInputException(langManager.getMessage("game.input.range.error"));
                }

                int row = rowChar - 'A';
                return new int[]{row, col};
            } catch (Exception e) {
                logger.error("Error parsing input '{}': {}", input, e.getMessage());
                throw new InvalidInputException(langManager.getMessage("game.invalid.input"));
            }
        }

        // Ask the player if they want to play again
        public boolean promptReplay(Scanner scanner) {
            System.out.println(langManager.getMessage("game.play.again"));
            String input = scanner.nextLine().trim();
            boolean replay = input.equalsIgnoreCase("y");

            logger.info("Replay option selected: {}", replay ? "Yes" : "No");
            return replay;
        }
}

