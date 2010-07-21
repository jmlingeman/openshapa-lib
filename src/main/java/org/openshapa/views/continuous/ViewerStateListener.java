package org.openshapa.views.continuous;


/**
 * Viewer listener interface.
 */
public interface ViewerStateListener {

    /**
     * Notify listener of a change made to the project.
     */
    void notifyStateChanged(String propertyChanged, String newValue);

}
