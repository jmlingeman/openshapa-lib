package org.openshapa.models.db;

/**
 * Represents a cell in the OpenSHAPA spreadsheet.
 */
public interface Cell {

    /**
     * @return The offset timestamp in milliseconds. Returns -1 if the offset
     * cannot be resolved.
     */
    long getOffset();

    /**
     * @return The onset timestamp in milliseconds. Returns -1 if the onset
     * cannot be resolved.
     */
    long getOnset();

    /**
     * @return The value stored in the cell as a string. Returns null if the
     * string value cannot be resolved.
     */
    String getValue();
}
