package com.minesweeper.ui;
import org.junit.jupiter.api.Test;
import org.minesweeper.exception.InvalidCellSelectionException;
import org.minesweeper.ui.InputParser;

import static org.junit.jupiter.api.Assertions.*;


public class InputParserTest {

    @Test
    void testValidCellSelection() throws InvalidCellSelectionException {
        int[] cell = InputParser.parseCellSelection("A1", 4);
        assertEquals(0, cell[0], "Row index should be 0 (for A)");
        assertEquals(0, cell[1], "Column index should be 0 (for 1)");
    }

    @Test
    void testNullCellSelection() {
        InvalidCellSelectionException exception = assertThrows(InvalidCellSelectionException.class, () -> {
            InputParser.parseCellSelection(null, 4);  // Null input
        });
        assertEquals("Invalid input format. Please enter a valid cell (e.g., A1).", exception.getMessage());
    }

    @Test
    void testEmptyCellSelection() {
        InvalidCellSelectionException exception = assertThrows(InvalidCellSelectionException.class, () -> {
            InputParser.parseCellSelection("", 4);  // Empty input
        });
        assertEquals("Invalid input format. Please enter a valid cell (e.g., A1).", exception.getMessage());
    }

    @Test
    void testOutOfBoundsColumn() {
        InvalidCellSelectionException exception = assertThrows(InvalidCellSelectionException.class, () -> {
            InputParser.parseCellSelection("A5", 4);  // Column out of bounds
        });
        assertEquals("Invalid column selection. Please select a column within the grid.", exception.getMessage());
    }


}
