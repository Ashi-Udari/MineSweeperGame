package org.minesweeper.config;

import org.minesweeper.exception.InvalidLanguageException;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LanguageManager {

    //Localize the language according to user selection

    private final ResourceBundle messages;

    public LanguageManager(String languageCode) throws InvalidLanguageException {
        if (languageCode == null || (!languageCode.equals("en") && !languageCode.equals("fr"))) {
            throw new InvalidLanguageException("Invalid language code. Please select 'en' for English or 'fr' for French.");
        }
        Locale locale = Locale.forLanguageTag(languageCode);
        messages = ResourceBundle.getBundle("messages", locale);
    }

    public String getMessage(String key) {
        try {
            return messages.getString(key);
        } catch (MissingResourceException e) {
            System.err.println("Message key not found: " + key);
            return "Missing message for key: " + key;
        }
    }
}


