package org.openshapa.plugins;

import java.io.FileFilter;


/**
 * Intermediate interface for defining file filters.
 */
public interface Filter {

    /**
     * @return Name of this filter.
     */
    String getName();

    /**
     * @return Corresponding IO file filter.
     */
    FileFilter getFileFilter();

    /**
     * @return String extensions.
     */
    Iterable<String> getExtensions();

}
