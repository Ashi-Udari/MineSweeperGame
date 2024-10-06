package org.minesweeper.controller;


import org.minesweeper.config.GameConfig;
import org.minesweeper.config.LanguageManager;
import org.minesweeper.core.Grid;
import org.minesweeper.exception.InvalidInputException;
import org.minesweeper.gamelogic.CellRevealer;
import org.minesweeper.gamelogic.MinePlacer;
import org.minesweeper.gamelogic.WinChecker;
import org.minesweeper.ui.GridView;

import java.util.Scanner;


public class MineSweeperGame {

    private final Grid grid;
    private final MinePlacer minePlacer;
    private final CellRevealer cellRevealer;
    private final WinChecker winChecker;
    private final LanguageManager langManager;
    private final GridView gridView;
    private boolean gameOver;

    public MineSweeperGame(GameConfig config, LanguageManager langManager) {
        this.grid = new Grid(config.getGridSize(), config.getMineCount());
        this.minePlacer = new MinePlacer(grid);
        this.cellRevealer = new CellRevealer(grid);
        this.winChecker = new WinChecker(grid);
        this.langManager = langManager;
        this.gridView = new GridView(grid);
        this.gameOver = false;

        minePlacer.placeMines();  // Place mines when game starts
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(langManager.getMessage("game.welcome"));

        // Print initial grid (all hidden)
        gridView.printGrid(false);

        while (!gameOver) {
            try {
                System.out.println(langManager.getMessage("game.select.cell"));
                String input = scanner.nextLine().trim();

                if (input.isEmpty()) {
                    throw new InvalidInputException(langManager.getMessage("game.input.error"));
                }

                // Convert input (like A1) to grid indices
                int[] indices = parseInput(input);
                int row = indices[0];
                int col = indices[1];

                // Reveal selected cell and check for game over
                if (!cellRevealer.revealCell(row, col)) {
                    System.out.println(langManager.getMessage("game.hit.mine"));
                    gameOver = true;
                    gridView.printGrid(true);  // Show all cells including mines
                } else if (winChecker.isGameWon()) {
                    System.out.println(langManager.getMessage("game.win"));
                    gameOver = true;
                    gridView.printGrid(true);  // Show the final grid with all revealed cells
                } else {
                    // Print updated grid with revealed cells
                    gridView.printGrid(false);
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }

            // After the game ends, ask the user to replay
            if (gameOver) {
                promptReplay(scanner);
            }
        }
        scanner.close();
    }

    // Converts user input like "A1" into row and column indices
    private int[] parseInput(String input) throws InvalidInputException {
        try {
            char rowChar = input.charAt(0);
            int col = Integer.parseInt(input.substring(1)) - 1;

            if (rowChar < 'A' || rowChar > 'Z' || col < 0 || col >= grid.getSize()) {
                throw new InvalidInputException(langManager.getMessage("game.input.range.error"));
            }

            int row = rowChar - 'A';
            return new int[]{row, col};
        } catch (Exception e) {
            throw new InvalidInputException(langManager.getMessage("game.invalid.input"));
        }
    }

    // Ask the player if they want to play again
    private void promptReplay(Scanner scanner) {
        System.out.println(langManager.getMessage("game.play.again"));
        String input = scanner.nextLine().trim();
        if (input.equalsIgnoreCase("y")) {
            gameOver = false;
            start();  // Restart the game
        }
    }
}

//public class MineSweeperGame {
//
//    private final Grid grid;
//    private final MinePlacer minePlacer;
//    private final CellRevealer cellRevealer;
//    private final WinChecker winChecker;
//    private final LanguageManager langManager;
//    private boolean gameOver;
//
//    public MineSweeperGame(GameConfig config, LanguageManager langManager) {
//        this.grid = new Grid(config.getGridSize(), config.getMineCount());
//        this.minePlacer = new MinePlacer(grid);
//        this.cellRevealer = new CellRevealer(grid);
//        this.winChecker = new WinChecker(grid);
//        this.langManager = langManager;
//        this.gameOver = false;
//
//        minePlacer.placeMines();
//    }
//
//    public void start() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(langManager.getMessage("game.welcome"));
//        printGrid(false);
//
//        while (!gameOver) {
//            try {
//                System.out.println(langManager.getMessage("game.select.cell"));
//                String input = scanner.nextLine().trim();
//                if (input.isEmpty()) {
//                    throw new InvalidInputException(langManager.getMessage("game.input.error"));
//                }
//                String[] inputs = input.split(" ");
//                if (inputs.length != 2) {
//                    throw new InvalidInputException(langManager.getMessage("game.invalid.input"));
//                }
//                int row = Integer.parseInt(inputs[0]);
//                int col = Integer.parseInt(inputs[1]);
//
//                if (!cellRevealer.isValidSelection(row, col)) {
//                    throw new InvalidInputException(langManager.getMessage("game.input.range.error"));
//                }
//
//                if (!cellRevealer.revealCell(row, col)) {
//                    System.out.println(langManager.getMessage("game.hit.mine"));
//                    gameOver = true;
//                } else if (winChecker.isGameWon()) {
//                    System.out.println(langManager.getMessage("game.win"));
//                    gameOver = true;
//                }
//
//                printGrid(false);
//            } catch (InvalidInputException | NumberFormatException e) {
//                System.out.println(langManager.getMessage("game.invalid.input") + e.getMessage());
//            }
//
//            if (gameOver) {
//                promptReplay(scanner);
//            }
//        }
//        scanner.close();
//    }
//
//    private void printGrid(boolean showMines) {
//        // Logic to display grid based on game state (revealed, hidden, etc.)
//    }
//
//    private void promptReplay(Scanner scanner) {
//        System.out.println(langManager.getMessage("game.thanks"));
//        System.out.println(langManager.getMessage("game.play.again"));
//        String input = scanner.nextLine().trim();
//        if (input.equalsIgnoreCase("y")) {
//            gameOver = false;
//            start();
//        }
//    }
//}


//    private final Grid grid;
//    private final GridView gridView;
//    private final LanguageManager languageManager;
//
//    public MineSweeperGame(GameConfig config, LanguageManager languageManager) {
//        this.grid = new Grid(config.getGridSize(), config.getMineCount());
//        this.gridView = new GridView(languageManager);
//        this.languageManager = languageManager;
//    }
//
//    public Grid getGrid() {
//        return grid;
//    }
//    public void startGame() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(languageManager.getMessage("game.welcome"));
//
//        while (true) {
//            gridView.displayGrid(grid);
//            System.out.println(languageManager.getMessage("game.select.prompt"));
//            String input = scanner.nextLine();
//
//            try {
//                int[] cell = InputParser.parseCellSelection(input, grid.getSize());
//                int row = cell[0];
//                int col = cell[1];
//
//                boolean safe = grid.revealCell(row, col);
//                if (!safe) {
//                    System.out.println(languageManager.getMessage("game.mine.hit"));
//                    break;
//                }
//
//                if (checkWinCondition()) {
//                    System.out.println(languageManager.getMessage("game.congratulations"));
//                    break;
//                }
//            } catch (InvalidCellSelectionException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    public boolean checkWinCondition() {
//        // Logic for determining if the player has won the game
//        return false;
//    }

//}
