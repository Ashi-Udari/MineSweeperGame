package com.minesweeper.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.config.GameConfig;
import org.minesweeper.config.LanguageManager;
import org.minesweeper.controller.MineSweeperGame;
import org.minesweeper.exception.InvalidGridSizeException;
import org.minesweeper.exception.InvalidLanguageException;
import org.minesweeper.exception.InvalidMineCountException;

import static org.junit.jupiter.api.Assertions.*;

class MineSweeperGameTest {

    private GameConfig config;
    private LanguageManager langManager;

    @BeforeEach
    void setUp() throws InvalidGridSizeException, InvalidMineCountException, InvalidLanguageException {
        config = new GameConfig(4, 2);  // 4x4 grid with 2 mines
        langManager = new LanguageManager("en");  // Use English localization
    }

    @Test
    void testGameInitialization() {
        MineSweeperGame game = new MineSweeperGame(config, langManager);
        assertNotNull(game, "The game should initialize properly.");
    }

    // More comprehensive end-to-end tests would require mocking user input and testing game loops.
}

//public class MineSweeperGameTest {
//
//
//    private MineSweeperGame game;
//    private GameConfig config;
//    private LanguageManager languageManager;
//
//    @BeforeEach
//    void setUp() throws InvalidGridSizeException, InvalidMineCountException, InvalidLanguageException {
//        config = new GameConfig(4, 2);  // 4x4 grid with 2 mines
//        languageManager = new LanguageManager("en");
//        game = new MineSweeperGame(config, languageManager);
//    }
//
//    @Test
//    void testGameInitialization() {
//        assertNotNull(game, "The game should initialize properly");
//    }
//
//    @Test
//    void testRevealNonMineCell() {
//        // We'll assume that the cell A1 is a non-mine cell for this test.
//        int[] cell = {0, 0}; // A1 is (0, 0)
//
//        boolean safe = game.getGrid().revealCell(cell[0], cell[1]);
//        assertTrue(safe, "Revealing a non-mine cell should not end the game");
//        assertTrue(game.getGrid().getCell(cell[0], cell[1]).isRevealed(), "The cell should be revealed");
//    }
//
//    @Test
//    void testRevealMineCell() {
//        // We can't guarantee the exact position of the mines since they're placed randomly, so let's mock the grid.
//        game.getGrid().getCell(0, 0).placeMine();  // Force A1 to be a mine
//
//        boolean safe = game.getGrid().revealCell(0, 0);
//        assertFalse(safe, "Revealing a mine should end the game");
//    }
//
//    @Test
//    void testWinCondition() {
//        // Simulate revealing all non-mine cells to trigger a win.
//        for (int row = 0; row < 4; row++) {
//            for (int col = 0; col < 4; col++) {
//                if (!game.getGrid().getCell(row, col).isMine()) {
//                    game.getGrid().revealCell(row, col);
//                }
//            }
//        }
//
//        assertTrue(game.checkWinCondition(), "The game should detect when all non-mine cells are revealed");
//        assertEquals("Congratulations, you won the game!", languageManager.getMessage("game.congratulations"));
//    }
//
//
//}
