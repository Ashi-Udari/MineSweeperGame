package org.minesweeper.config;

import org.minesweeper.exception.InvalidLanguageException;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {

    private final ResourceBundle messages;

    public LanguageManager(String languageCode) throws InvalidLanguageException {
        if (languageCode == null || (!languageCode.equals("en") && !languageCode.equals("fr"))) {
            throw new InvalidLanguageException("Invalid language code. Please select 'en' for English or 'fr' for French.");
        }
        Locale locale = new Locale(languageCode);
        messages = ResourceBundle.getBundle("messages", locale);
    }

    public String getMessage(String key) {
        return messages.getString(key);
    }
}


