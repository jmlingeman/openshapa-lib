package org.openshapa.plugins;

import javax.swing.AbstractButton;


/**
 * Custom actions interface.
 *
 * @see CustomActionsAdapter
 *
 */
public interface CustomActions {

    /**
     * @return A button for the user to trigger custom action 1.
     * Null if not supported.
     */
    AbstractButton getActionButton1();

    /**
     * @return A button for the user to trigger custom action 2.
     * Null if not supported.
     */
    AbstractButton getActionButton2();

    /**
     * @return A button for the user to trigger custom action 3.
     * Null if not supported.
     */
    AbstractButton getActionButton3();

}
