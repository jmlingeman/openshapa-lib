package org.openshapa.models.db;

/**
 * Holds a value as a string, and offset / onset as millisecond timestamps.
 * Relates to a DataCell.
 */
public interface Cell {

    /**
     * @return The offset timestamp in milliseconds.
     */
    long getOffset();

    /**
     * @return The onset timestamp in milliseconds.
     */
    long getOnset();

    /**
     * @return The value stored in the cell as a string.
     */
    String getValue();
}
