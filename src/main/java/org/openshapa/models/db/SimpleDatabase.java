/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openshapa.models.db;

import java.util.List;

/**
 * An interface which abstracts away from the specific underlying database,
 * with methods to access columns and cells in an intuitive manner.
 */
public interface SimpleDatabase {

    /** @return A collection of SimpleVariables from this database. */
    List<SimpleVariable> getAllVariables();

}
