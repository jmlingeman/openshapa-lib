/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openshapa.models.db;

import java.util.ArrayList;
import java.util.List;

/**
 *  Just a collection of cells, relates to a DataColumn.
 */
public final class SimpleVariable {

    private String name;

    private List<SimpleCell> cells = new ArrayList<SimpleCell>();

    public SimpleVariable(final String newName) {
        name = newName;
    }

    public void addCell(final SimpleCell newCell) {
        cells.add(newCell);
    }

    public List<SimpleCell> getCells() {
        return cells;
    }

    public String getName() {
        return name;
    }

}
