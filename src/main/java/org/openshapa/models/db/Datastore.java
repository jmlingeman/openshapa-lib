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
 * An interface which abstracts away from the specific underlying database,
 * with methods to access columns and cells in an intuitive manner.
 */
public interface Datastore {

    /**
     * @return All the variables held in the datastore.
     */
    List<Variable> getAllVariables();

    /**
     * @return The variables selected in the datastore.
     */
    List<Variable> getSelectedVariables();

    /**
     * @return All the selected cells, across the entire datastore.
     */
    List<Cell> getSelectedCells();

    /**
     * @param varName The name of the variable to fetch.
     *
     * @return The variable that matches varName, NULL if unable to find a
     * variable that matches varName.
     */
    Variable getVariable(String varName);

    /**
     * @param The cell that we are looking for it's parent variable.
     *
     * @return The parent variable for the supplied cell.
     */
    Variable getVariable(Cell cell);

    /**
     * Creates and adds a variable to this datastore.
     *
     * @param name The name of the variable to add to the datastore.
     * @param type The type of variable to add to the datastore.
     *
     * @return The new variable that was added to the datastore.
     * @throws UserWarningException
     */
    Variable createVariable(final String name, final Variable.type type)
    throws UserWarningException;

    /**
     * Adds a variable to the datastore.
     *
     * @param var The new variable to add to the datastore.
     */
    @Deprecated
    void addVariable(final Variable var);

    /**
     * Removes a variable from the datastore.
     *
     * @param var The variable to remove from the datastore.
     */
    void removeVariable(final Variable var);

    /**
     * Removes a variable from the datastore.
     *
     * @param cell The cell to remove from the datastore.
     */
    void removeCell(final Cell cell);

    /**
     * @return The name of the datastore.
     */
    String getName();

    /**
     * @return True if the datastore has changed since it was last saved, false
     * otherwise.
     */
    boolean isChanged();

    /**
     * Sets the name of the datastore.
     *
     * @param datastoreName The new name to use for the datastore.
     */
    void setName(final String datastoreName);

    /**
     * Sets the title notifier that needs to be informed when the title of the
     * application needs to be updated.
     */
    void setTitleNotifier(final TitleNotifier titleNotifier);

    /**
     * Adds a listener that needs to be notified when the datastore changes.
     */
    void addListener(final DatastoreListener listener);

    /**
     * Removes a listener from the list of things that need to be notified when
     * the datastore changes.
     */
    void removeListener(final DatastoreListener listener);
}
