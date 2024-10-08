package com.minesweeper.config;

import org.junit.jupiter.api.Test;
import org.minesweeper.config.LanguageManager;
import org.minesweeper.exception.InvalidLanguageException;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class LanguageManagerTest {

    @Test
    void testValidLanguage() throws InvalidLanguageException {
        LanguageManager langManager = new LanguageManager("en");
        assertEquals("Welcome to Minesweeper!", langManager.getMessage("game.welcome"));
    }

    @Test
    void testInvalidLanguage() {
        assertThrows(InvalidLanguageException.class, () -> new LanguageManager("de"));  // Unsupported language
    }

    @Test
    void testFrenchLanguage() throws InvalidLanguageException {
        LanguageManager langManager = new LanguageManager("fr");
        assertEquals("Bienvenue à Démineur!", langManager.getMessage("game.welcome"));
    }


}
