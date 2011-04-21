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
     * Gets the 'index' cell from the variable that has been sorted temporally.
     *
     * @param index The index (from first onset to last offset) of the cell.
     *
     * @return The cell.
     */
    Cell getCellTemporally(final int index);

    /**
     * @return All the cells stored in the variable using a temporal order.
     */
    List<Cell> getCellsTemporally();

    /**
     * Selects the variable in the datastore.
     * 
     * @param selected True if the variable is selected, false otherwise.
     */
    void setSelected(final boolean selected);

    /**
     * @return True if the variable is currently selected or not.
     */
    boolean isSelected();

    /**
     * @return The name of the variable as a string.
     */
    String getName();
}
