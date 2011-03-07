package org.openshapa.models.db;

import java.util.List;

/**
 * An interface which abstracts away from the specific underlying database,
 * with methods to access columns and cells in an intuitive manner.
 */
public interface Datastore {

    /**
     * @return A collection of SimpleVariables from this database.
     */
    List<Variable> getAllVariables();

    /**
     * @return The name of the datastore.
     */
    String getName();
}
