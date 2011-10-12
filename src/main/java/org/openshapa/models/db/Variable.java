/*
 * Copyright (c) 2011 OpenSHAPA Foundation, http://openshapa.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
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
     * Hides the variable in the datastore.
     *
     * @param hidden True if the variable is hidden, false otherwise.
     */
    void setHidden(final boolean hidden);

    /**
     * @return True if the variable is currently hidden or not.
     */
    boolean isHidden();

    /**
     * @return The name of the variable as a string.
     */
    String getName();

    /**
     * Sets the name of the variable.
     *
     * @param the new name to set with this database.
     */
    void setName(final String newName) throws UserWarningException;
}
