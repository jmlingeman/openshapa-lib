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
    List<Cell> getCells();

    /**
     * @return All the cells stored in the variable using a temporal order.
     */
    List<Cell> getCellsTemporally();

    /**
     * @return The name of the variable as a string.
     */
    String getName();
}
