package org.openshapa.views;

import org.openshapa.plugins.DataViewer;

/**
 * Creators of plugins DO NOT NEED TO IMPLEMENT this class - the method
 * 'setParentController' of DataViewer is used to notify each viewer of its
 * parent controller. When an implemeting viewer is closed, it should notify
 * the parent controller that it no longer requires commands by calling
 * shutdown and supplying itself as the argument. i.e.
 *
 * parentController.shutdown(this);
 *
 * It would be nice if we could use a weak reference instead (see bug:755)
 */
public interface DataController {

    /**
     * Remove the specifed viewer form the controller.
     *
     * @param viewer The viewer to shutdown.
     * @return True if the controller contained this viewer.
     */
    boolean shutdown(final DataViewer viewer);
}
