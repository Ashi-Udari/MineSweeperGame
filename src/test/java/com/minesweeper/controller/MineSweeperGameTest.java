package com.minesweeper.controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.minesweeper.config.GameConfig;
import org.minesweeper.config.LanguageManager;
import org.minesweeper.controller.MineSweeperGame;
import org.minesweeper.core.Grid;
import org.minesweeper.exception.InvalidGridSizeException;
import org.minesweeper.exception.InvalidLanguageException;
import org.minesweeper.exception.InvalidMineCountException;
import org.minesweeper.gamelogic.WinChecker;

import static org.junit.jupiter.api.Assertions.*;

class MineSweeperGameTest {

    private GameConfig config;
    private LanguageManager langManager;
    private MineSweeperGame game;


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


    @Test
    void testValidGameConfiguration() throws InvalidGridSizeException, InvalidMineCountException {
        GameConfig validConfig = new GameConfig(10, 3);  // Valid 10x10 grid with 3 mines
        assertEquals(10, validConfig.getGridSize());
        assertEquals(3, validConfig.getMineCount());
    }

    // More comprehensive end-to-end tests would require mocking user input and testing game loops.
}
