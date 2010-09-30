package org.openshapa.models.db;

import java.util.List;

/**
 *  Just a collection of cells, relates to a DataColumn.
 */
public interface Variable {

    /**
     * Adds a new cell to the variable.
     *
     * @param newCell
     */
    void addCell(final Cell newCell);

    /**
     * @return All the cells stored in the variable.
     */
    public List<Cell> getCells();

    /**
     * @return The name of the variable as a string.
     */
    public String getName();
}
