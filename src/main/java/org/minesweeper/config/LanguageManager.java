package org.minesweeper.config;

import org.minesweeper.exception.InvalidLanguageException;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {

    private ResourceBundle messages;

    public LanguageManager(String languageCode) throws InvalidLanguageException {
        Locale locale = new Locale(languageCode);
        try {
            messages = ResourceBundle.getBundle("messages", locale);
        } catch (Exception e) {
            throw new InvalidLanguageException("Invalid language code. Please select 'en' for English or 'fr' for French.");
        }
    }

    public String getMessage(String key) {
        return messages.getString(key);
    }

}
